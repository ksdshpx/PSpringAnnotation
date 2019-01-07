package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.ksdshpx.beans.Person;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:22:41
 */
//告诉spring这是一个配置类
@Configuration
public class MainConfig {
	//将person类加载到容器中，类型为返回值类型，id默认为方法名
	@Bean
	public Person person() {
		return new Person("liSi", 20);
	}
}
