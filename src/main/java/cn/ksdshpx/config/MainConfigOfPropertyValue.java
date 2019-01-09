package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.ksdshpx.beans.Person;

/**
 * @author peng.x
 * @date 2019年1月9日 下午1:09:28
 */
@Configuration
public class MainConfigOfPropertyValue {
	@Bean
	public Person person() {
		return new Person();
	}
}
