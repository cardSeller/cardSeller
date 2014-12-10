package com.card.seller.backoffice.security;

import com.card.seller.backoffice.service.UserService;
import com.card.seller.domain.*;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: minj
 * Date: 13-12-16
 * Time: 上午9:56
 */
public abstract class AuthorizationRealm extends AuthorizingRealm {

    private List<String> defaultPermission = Lists.newArrayList();
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationRealm.class);

    @Autowired
    private UserService userService;

    private static final String OR_OPERATOR = " or ";
    private static final String AND_OPERATOR = " and ";
    private static final String NOT_OPERATOR = "not ";

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LOGGER.debug("start authorization.");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        SessionVariable model = (SessionVariable) principals.getPrimaryPrincipal();
        Assert.notNull(model, "找不到principals中的SessionVariable");
        Long id = model.getUser().getId();
        //加载用户的组信息和资源信息
        List<Resource> authorizationInfo = userService.getUserResources(id);
        List<Group> groupsList = userService.getUserGroups(id);
        List<Resource> resourcesList = userService.mergeResourcesToParent(authorizationInfo, ResourceType.Security);
        model.setAuthorizationInfo(authorizationInfo);
        model.setGroupsList(groupsList);
        model.setMenusList(resourcesList);
        //添加用户拥有的permission
        addPermissions(info, authorizationInfo);
        model.setPermissionList(info.getStringPermissions());
        SecurityUtils.getSubject().getSession().setAttribute("sv", model);
        LOGGER.debug("doGetAuthorizationInfo has menuList size : " + model.getMenusList().size());
        return info;
    }

    /**
     * 通过资源集合，将集合中的permission字段内容解析后添加到SimpleAuthorizationInfo授权信息中
     *
     * @param info              SimpleAuthorizationInfo
     * @param authorizationInfo 资源集合
     */
    private void addPermissions(SimpleAuthorizationInfo info, List<Resource> authorizationInfo) {
        //解析当前用户资源中的permissions
        List<String> temp = CollectionUtils.extractToList(authorizationInfo, "permission", true);
        List<String> permissions = getValue(temp, "perms\\[(.*?)\\]");

        //添加默认的permissions到permissions
        if (CollectionUtils.isNotEmpty(defaultPermission)) {
            CollectionUtils.addAll(permissions, defaultPermission.iterator());
        }

        //将当前用户拥有的permissions设置到SimpleAuthorizationInfo中
        info.addStringPermissions(permissions);

    }

    /**
     * 通过正则表达式获取字符串集合的值
     *
     * @param obj   字符串集合
     * @param regex 表达式
     * @return List
     */
    private List<String> getValue(List<String> obj, String regex) {

        List<String> result = new ArrayList<String>();

        if (CollectionUtils.isEmpty(obj)) {
            return result;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(StringUtils.join(obj, ","));

        while (matcher.find()) {
            result.add(matcher.group(1));
        }

        return result;
    }

    /**
     * 设置默认permission
     *
     * @param defaultPermission permission
     */
    public void setDefaultPermission(List<String> defaultPermission) {
        this.defaultPermission = defaultPermission;
    }

    /**
     * 设置默认permission
     *
     * @param defaultPermissionString permission 如果存在多个值，使用逗号","使用逗号分割
     */
    public void setDefaultPermissionString(String defaultPermissionString) {
        String[] perms = StringUtils.split(defaultPermissionString, ",");
        CollectionUtils.addAll(defaultPermission, perms);
    }

    @Override
    public boolean isPermitted(PrincipalCollection principals, String permission) {
        if (permission.contains(OR_OPERATOR)) {
            String[] permissions = permission.split(OR_OPERATOR);
            for (String orPermission : permissions) {
                if (isPermittedWithNotOperator(principals, orPermission)) {
                    return true;
                }
            }
            return false;
        } else if (permission.contains(AND_OPERATOR)) {
            String[] permissions = permission.split(AND_OPERATOR);
            for (String orPermission : permissions) {
                if (!isPermittedWithNotOperator(principals, orPermission)) {
                    return false;
                }
            }
            return true;
        } else {
            return isPermittedWithNotOperator(principals, permission);
        }
    }

    private boolean isPermittedWithNotOperator(PrincipalCollection principals, String permission) {
        if (permission.startsWith(NOT_OPERATOR)) {
            return !super.isPermitted(principals, permission.substring(NOT_OPERATOR.length()));
        } else {
            return super.isPermitted(principals, permission);
        }
    }
}
