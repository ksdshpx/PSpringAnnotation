package cn.ksdshpx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.ksdshpx.beans.Person;
import cn.ksdshpx.config.MainConfigOfPropertyValue;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTestOfPropertyValue {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
		String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
		for (String beanNames : beanNamesForType) {
			System.out.println(beanNames);
		}
		Person person = (Person) ctx.getBean("person");
		System.out.println(person);
	}
}
