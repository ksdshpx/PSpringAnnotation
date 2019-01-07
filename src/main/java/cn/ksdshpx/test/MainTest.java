package cn.ksdshpx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ksdshpx.beans.Person;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:14:14
 */
public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
	}
}
