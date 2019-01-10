package cn.ksdshpx.test;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import cn.ksdshpx.beans.Person;
import cn.ksdshpx.config.MainConfigOfProfile;
import cn.ksdshpx.config.MainConfigOfPropertyValue;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTestOfProfile {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				MainConfigOfProfile.class);
		String[] beanNamesForType = ctx.getBeanNamesForType(DataSource.class);
		for (String beanName : beanNamesForType) {
			System.out.println(beanName);
		}
	}
}
