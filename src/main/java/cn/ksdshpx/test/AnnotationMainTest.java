package cn.ksdshpx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ksdshpx.beans.Person;
import cn.ksdshpx.config.MainConfig;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:24:32
 */
public class AnnotationMainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
		Person person = ctx.getBean("person",Person.class);
		System.out.println(person);
	}
}
