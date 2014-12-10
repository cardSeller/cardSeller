package com.card.seller.backoffice.service;

import com.card.seller.domain.SessionVariable;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 系统变量工具类
 *
 * @author vincent
 */
@Component
public class SystemVariableUtils {

	static public String DEFAULT_DICTIONARY_VALUE = "无";

	/**
	 * 为了能够借助Spring自动注入systemDictionaryManager这个Bean.写一个空方法借助@PostConstruct注解注入
	 */
	@PostConstruct
	public void init() {

	}

	/**
	 * 获取当前安全模型
	 *
	 * @return {@link com.card.seller.domain.SessionVariable}
	 */
	public static SessionVariable getSessionVariable() {

		Subject subject = SecurityUtils.getSubject();

		if (subject != null && subject.getPrincipal() != null && subject.getPrincipal() instanceof SessionVariable) {
			return (SessionVariable) subject.getPrincipal();
		}

		return null;
	}

	/**
	 * 判断当前会话是否登录
	 *
	 * @return boolean
	 */
	public static boolean isAuthenticated() {
		return SecurityUtils.getSubject().isAuthenticated();
	}

}
