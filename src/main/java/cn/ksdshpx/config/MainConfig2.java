package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import cn.ksdshpx.beans.Person;
import cn.ksdshpx.condition.LinuxCondition;
import cn.ksdshpx.condition.WindowsCondition;

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
	 * 
	 * 
	 * 懒加载：
	 * 		单实例bean：默认在容器启动时创建对象
	 *      懒加载：容器启动时不创建对象，而在第一次获取bean时创建对象，并进行一些初始化
	 */
	/*@Scope("prototype")*/
	@Lazy
	@Bean("person")
	public Person person() {
		System.out.println("往容器中添加person...");
		return new Person("wangWu", 30);
	}
	
	/*
	 * @Conditional:按照一定的条件进行判断，满足一定的条件才会将bean注册到IOC容器中
	 * 如果系统是windows,给容器中注册bill
	 * 如果系统是linux,给容器中注册linus
	 */
	@Conditional({WindowsCondition.class})
	@Bean("bill")
	public Person person01() {
		return new Person("Bill",25);
	}
	
	@Conditional({LinuxCondition.class})
	@Bean("linus")
	public Person person02() {
		return new Person("linus",36);
	}
}
