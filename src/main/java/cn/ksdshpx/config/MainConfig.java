package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import cn.ksdshpx.beans.Person;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:22:41
 */
//告诉spring这是一个配置类
@Configuration
/*
 * @ComponentScan(value = "cn.ksdshpx", excludeFilters = {
 * 
 * @Filter(type = FilterType.ANNOTATION, classes = { Controller.class,
 * Service.class }) })
 */
@ComponentScan(value = "cn.ksdshpx", includeFilters = { @Filter(type = FilterType.ANNOTATION, classes = {
		Controller.class, Service.class }) }, useDefaultFilters = false)
public class MainConfig {
	// 将person类加载到容器中，类型为返回值类型，id默认为方法名
	@Bean
	public Person person() {
		return new Person("liSi", 20);
	}
}
