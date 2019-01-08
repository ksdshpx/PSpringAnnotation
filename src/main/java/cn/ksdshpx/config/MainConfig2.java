package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import cn.ksdshpx.beans.Color;
import cn.ksdshpx.beans.ColorFactoryBean;
import cn.ksdshpx.beans.Person;
import cn.ksdshpx.beans.Red;
import cn.ksdshpx.condition.LinuxCondition;
import cn.ksdshpx.condition.MyImportBeanDefinitionRegistrar;
import cn.ksdshpx.condition.MyImportSelector;
import cn.ksdshpx.condition.WindowsCondition;

/**
 * @author peng.x
 * @date 2019年1月7日 下午9:34:15
 */
@Import({ Color.class, Red.class ,MyImportSelector.class ,MyImportBeanDefinitionRegistrar.class})
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
	
	/**
	 * 给容器中导入组件
	 * 1)包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）[自己写的类]
	 * 2)@Bean[导入的第三方包里的组件]
	 * 3)@Import[快速给容器中导入一个组件]
	 * 	  1.@Import(要导入到容器中的组件)：容器中就会自动注册这个组件，id默认为全类名
	 *    2.ImportSelector:返回需要导入的组件的全类名的数组
	 *    3.ImportBeanDefinitionRegistrar:手动注册bean到容器中
	 * 4)使用Spring提供的FactoryBean(工厂Bean)
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
}
