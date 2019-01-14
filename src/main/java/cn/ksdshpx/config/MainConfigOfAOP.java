package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import cn.ksdshpx.aop.LogAspect;
import cn.ksdshpx.aop.MathCalculator;

/**
 * @author peng.x
 * @date 2019年1月14日 上午9:38:23
 * AOP:【底层是动态代理】
 * 	  指在程序运行期间，动态的将某段代码切入到指定方法指定位置进行运行的编程方式；
 * 
 * 1.导入springaop包(spring-aspects)
 * 2.定义一个业务逻辑类(MathCalculator),在业务逻辑运行的时候将日志进行打印（方法运行之前，方法结束后...）
 * 3.定义一个日志切面类(LogAspect):切面类里面的方法需要动态感知MathCalculator.div运行到哪里了
 * 		通知方法：
 * 				前置通知(@Before)：logStart在目标方法(div)运行之前运行
 * 				后置通知(@After)：logEnd在目标方法(div)运行结束之后运行(无论方法正常结束还是异常结束)
 * 				返回通知(@AfterReturning)：logReturn在目标方法(div)正常返回之后运行
 * 				异常通知(@AfterThrowing)：logException在目标方法(div)运行出现之后运行
 * 				环绕通知(@Around)：动态代理，手动推进目标方法运行(joinPoint.proceed())
 * 4.给切面类的目标方法标注何时何地运行(通知注解)
 * 5.将切面类和业务逻辑类(目标方法所在的类)都加入到容器中
 * 6.必须告诉Spring哪个类是切面类(给切面类上加一个注解@Aspect)
 * 7.需要给配置类中加@EnableAspectJAutoProxy[开启基于注解的AOP模式]
 * 
 * 三步：
 * 1).将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类
 * 2).在切面类上的每个通知方法上都标注通知注解，告诉Spring何时何地运行（切入点表达式）
 * 3).开启基于注解的AOP模式
 */
@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
	
	@Bean
	public MathCalculator mathCalculator() {
		return new MathCalculator();
	}

	@Bean
	public LogAspect logAspect() {
		return new LogAspect();
	}
}
