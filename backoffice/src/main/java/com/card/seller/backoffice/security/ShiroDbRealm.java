package com.card.seller.backoffice.security;

import com.card.seller.backoffice.service.UserService;
import com.card.seller.domain.Member;
import com.card.seller.domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by minjie
 * Date:14-11-13
 * Time:下午3:54
 */
public class ShiroDbRealm extends AuthorizingRealm {

    public static final int HASH_ITERATION = 1024;
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private UserService userService;

    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME);
        matcher.setHashIterations(HASH_ITERATION);
        matcher.setStoredCredentialsHexEncoded(false);
        setCredentialsMatcher(matcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        LOGGER.info("bo shiro do authentication username:" + username);
        if (StringUtils.isBlank(username)) {
            throw new AccountException("用户名不能为空");
        }
        User user = userService.getUserByName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名为：" + username + " 不存在.");
        }
        SecurityUtils.getSubject().getSession().setAttribute("sv", user);
        return new SimpleAuthenticationInfo(user.getName(), user.getPwd(), ByteSource.Util.bytes(Base64.decode(user.getSalt())), getName());
    }
}
