package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.ksdshpx.beans.Car;
import cn.ksdshpx.beans.Color;

/**
 * @author peng.x
 * @date 2019年1月10日 上午9:44:23
 * 自动装配：
 * 		Spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值
 * 1)@Autowired：自动注入[Spring定义]
 * 		1.默认按照类型去容器找对应的组件，找到就赋值
 *      2.如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *      3.使用@Qualifier("bookDao")指定要装配的组件的id，而不是使用属性名
 *      4.自动装配默认一定要将属性赋值好，没有就会报错，可以使用@Autowired(required=false)防止报错，不存在就赋值为null
 *      5.让Spring进行装配的时候默认使用首选的Bean,也可以继续使用@Qualifier("bookDao")指定需要装配的bean的名字
 *   
 * 2)Spring还支持使用@Resource(JSR250)和@Inject(JSR330)[Java规范的注解]
 * 		1.@Resource:和@Autowired一样可以实现自动装配，但它默认是按照组件名称进行自动装配
 * 		            没有支持@Primary功能，没有支持@Autowired(required=false)功能
 *      2.@Inject:需要导入javax.inject包，和@Autowired的功能一样，没有支持@Autowired(required=false)功能
 *      
 * 3)@Autowired标注位置：构造器、方法、参数、属性：都是从IOC容器中获取参数组件的值
 * 		1.标注在方法位置
 * 		2.标注在构造器位置：如果组件只有一个有参构造器，这个有参构造器的@Autowired可以省略
 * 		3.标注在参数位置
 * 
 * 4)自定义组件想要使用Spring底层的一些组件(ApplicationContext、BeanFactory)
 * 		只需要让自定义组件实现XxxAware接口:在创建对象的时候会调用接口规定的方法，注入相关组件
 * 		把Spring的一些底层组件注入到自定义的bean中
 * 		XxxAware的功能都是使用XxxAwareProcessor(BeanPostProcessor的实现类)来处理的
 */
@ComponentScan({"cn.ksdshpx.controller","cn.ksdshpx.service","cn.ksdshpx.dao","cn.ksdshpx.beans"})
@Configuration
public class MainConfigOfAutowired {

	/**
	 * @Bean标注的方法创建对象的时候，方法参数的值从IOC容器中获取
	 * @param car
	 * @return
	 */
	@Bean
	public Color color(Car car) {
		Color color = new Color();
		color.setCar(car);
		return color;
	}
}
