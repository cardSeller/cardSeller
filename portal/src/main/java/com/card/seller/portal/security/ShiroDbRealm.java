package com.card.seller.portal.security;

import com.card.seller.domain.Member;
import com.card.seller.portal.service.MemberService;
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
 * User: minj
 * Date: 13-12-4
 * Time: 下午5:37
 */
public class ShiroDbRealm extends AuthorizingRealm {

    public static final int HASH_ITERATION = 1024;
	private static final Logger LOGGER = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private MemberService memberService;

    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Sha256Hash.ALGORITHM_NAME);
        matcher.setHashIterations(HASH_ITERATION);
        matcher.setStoredCredentialsHexEncoded(false);
        setCredentialsMatcher(matcher);
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        LOGGER.info("shiro do authentication username:" + username);
        if (StringUtils.isBlank(username)) {
            throw new AccountException("用户名不能为空");
        }
        Member member = memberService.getMemberByName(username);
        if (member == null) {
            throw new UnknownAccountException("用户名为：" + username + " 不存在.");
        }
        SecurityUtils.getSubject().getSession().setAttribute("sv", member);
        return new SimpleAuthenticationInfo(member.getName(), member.getPwd(), ByteSource.Util.bytes(Base64.decode(member.getSalt())), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
