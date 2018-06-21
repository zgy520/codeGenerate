package com.tonfun.tools.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.tonfun.tools.helper.NoSpringContext.AutowireHelper;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月17日 下午5:42:12
*/
@Component
public class NoContextConfig {
	@Bean
	public AutowireHelper autowireHelper() {
		return AutowireHelper.getInstance();
	}
}
