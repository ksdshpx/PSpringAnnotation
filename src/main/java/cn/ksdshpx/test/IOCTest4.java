package cn.ksdshpx.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.ksdshpx.config.MainConfig2;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTest4 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig2.class);
		String[] beanNames = ctx.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		//工厂bean获取的是调用getObject创建的对象
		Object bean = ctx.getBean("colorFactoryBean");
		Object bean2 = ctx.getBean("colorFactoryBean");
		System.out.println(bean == bean2);
		System.out.println("bean的类型：" + bean.getClass().getName());//cn.ksdshpx.beans.Color
		//获取工厂bean本身需要加入前缀&
		Object bean3 = ctx.getBean("&colorFactoryBean");
		System.out.println("bean的类型：" + bean3.getClass().getName());//cn.ksdshpx.beans.ColorFactoryBean
	}
}
