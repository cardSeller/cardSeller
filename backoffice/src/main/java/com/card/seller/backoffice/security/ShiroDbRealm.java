package com.card.seller.backoffice.security;

import com.card.seller.backoffice.service.UserService;
import com.card.seller.domain.SessionVariable;
import com.card.seller.domain.Status;
import com.card.seller.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


/**
 * User: minj
 * Date: 13-12-4
 * Time: 下午5:37
 */
public class ShiroDbRealm extends AuthorizationRealm {

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
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		LOGGER.info("doGetAuthenticationInfo");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		String username = token.getUsername();
		LOGGER.info("username:" + username);
        if (username == null) {
            throw new AccountException("用户名不能为空");
        }
        User user = userService.getUserByUsername(username);
        if (user == null) {
			throw new UnknownAccountException("用户不存在");
		}
        if (user.getStatus().equals(Status.Disable.getValue())) {
            throw new DisabledAccountException("你的账户已被禁用,请联系管理员开通.");
        }
		user.setLastLoginTime(new Date());
		userService.updateUser(user);
        SessionVariable sessionVariable = new SessionVariable(user);
		LOGGER.info("doGetAuthenticationInfo success");
		return new SimpleAuthenticationInfo(sessionVariable, user.getPwd(), ByteSource.Util.bytes(Base64.decode(user.getSalt())), getName());
    }
}
