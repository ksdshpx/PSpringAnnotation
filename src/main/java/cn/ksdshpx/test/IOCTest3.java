package cn.ksdshpx.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

import cn.ksdshpx.beans.Person;
import cn.ksdshpx.config.MainConfig2;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTest3 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
		for (String beanNames : beanNamesForType) {
			System.out.println(beanNames);
		}
		Map<String, Person> persons = ctx.getBeansOfType(Person.class);
		System.out.println(persons);
		Environment environment = ctx.getEnvironment();
		String osName = environment.getProperty("os.name");
		System.out.println(osName);
	}
}
