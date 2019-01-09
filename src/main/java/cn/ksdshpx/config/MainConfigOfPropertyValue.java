package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import cn.ksdshpx.beans.Person;

/**
 * @author peng.x
 * @date 2019年1月9日 下午1:09:28
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行环境变量里面的值
@PropertySource(value= {"classpath:/person.properties"})
@Configuration
public class MainConfigOfPropertyValue {
	@Bean
	public Person person() {
		return new Person();
	}
}
