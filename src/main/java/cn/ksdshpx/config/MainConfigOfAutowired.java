package cn.ksdshpx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author peng.x
 * @date 2019年1月10日 上午9:44:23
 * 自动装配：
 * 		Spring利用依赖注入(DI)，完成对IOC容器中各个组件的依赖关系赋值
 * 1)@Autowired：自动注入
 * 		1.默认按照类型去容器找对应的组件，找到就赋值
 *      2.如果找到多个相同类型的组件，再将属性的名称作为组件的id去容器中查找
 *      3.使用@Qualifier("bookDao")指定要装配的组件的id，而不是使用属性名
 *      4.自动装配默认一定要将属性赋值好，没有就会报错，可以使用@Autowired(required=false)防止报错，不存在就赋值为null
 *      5.让Spring进行装配的时候默认使用首选的Bean
 */
@ComponentScan({"cn.ksdshpx.controller","cn.ksdshpx.service","cn.ksdshpx.dao"})
@Configuration
public class MainConfigOfAutowired {

}
