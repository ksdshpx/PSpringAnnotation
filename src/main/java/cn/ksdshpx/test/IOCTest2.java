package cn.ksdshpx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ksdshpx.beans.Person;
import cn.ksdshpx.config.MainConfig2;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTest2 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		Person p1 = ctx.getBean("person", Person.class);
		Person p2 = ctx.getBean("person", Person.class);
		System.out.println(p1 == p2);//true
	}
}
