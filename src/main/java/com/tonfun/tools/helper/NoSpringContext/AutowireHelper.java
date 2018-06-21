package com.tonfun.tools.helper.NoSpringContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月17日 下午5:32:03
*/
public final class AutowireHelper implements ApplicationContextAware {
	
	private static final AutowireHelper INSTANCE = new AutowireHelper();
	private static ApplicationContext applicationContext;
	private AutowireHelper() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Tries to autowire the specified instance of the class if one of the specified beans which need to be autowired
	 * @param classToAutowire
	 * @param beansToAutowireInClass
	 */
	public static void autowire(Object classToAutowire,Object... beansToAutowireInClass) {
		for(Object bean : beansToAutowireInClass) {
			if (bean == null) {
				applicationContext.getAutowireCapableBeanFactory().autowireBean(classToAutowire);
				return;
			}
		}
	}

	@Override
	public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		AutowireHelper.applicationContext = applicationContext;
	}
	public static AutowireHelper getInstance() {
		return INSTANCE;
	}

}
