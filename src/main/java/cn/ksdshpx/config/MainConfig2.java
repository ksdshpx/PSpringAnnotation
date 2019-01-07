package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import cn.ksdshpx.beans.Person;

/**
 * @author peng.x
 * @date 2019年1月7日 下午9:34:15
 */
@Configuration
public class MainConfig2 {
	// 默认是单实例的
	/*
	 * singleton:单实例(IOC容器启动会调用方法创建对象放到IOC容器中，以后每次获取就是从容器中拿)
	 * prototype:多实例 (IOC容器启动不会调用方法创建对象放到IOC容器中，而是每次获取对象时会调用方法创建对象放到IOC容器中)
	 * request:同一次请求创建一个实例 
	 * session:同一个session创建一个实例
	 */
	@Scope("prototype")
	@Bean("person")
	public Person person() {
		return new Person("wangWu", 30);
	}
}
