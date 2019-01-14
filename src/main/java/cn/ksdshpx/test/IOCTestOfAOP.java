package cn.ksdshpx.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ksdshpx.aop.MathCalculator;
import cn.ksdshpx.config.MainConfigOfAOP;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTestOfAOP {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCalculator mathCalculator = ctx.getBean(MathCalculator.class);
		mathCalculator.div(1, 1);
		ctx.close();
	}
}
