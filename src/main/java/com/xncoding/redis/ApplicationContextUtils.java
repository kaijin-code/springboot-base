package com.xncoding.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {

	private static ApplicationContext context;

	public static void setContext(ApplicationContext applicationContext) {
		context = applicationContext;
	}

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	public static <T> T getBean(Class<T> t) {
		return context.getBean(t);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;

	}

	public static String getProperties(String key) {
		return context.getEnvironment().getProperty(key);
	}

}
