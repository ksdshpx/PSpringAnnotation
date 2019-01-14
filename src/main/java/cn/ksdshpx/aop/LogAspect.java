package cn.ksdshpx.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author peng.x
 * @date 2019年1月14日 上午9:48:39
 */
@Aspect
public class LogAspect {
	// 抽取公共的切入点表达式
	@Pointcut("execution(public int cn.ksdshpx.aop.MathCalculator.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		System.out.println(joinPoint.getSignature().getName() + "开始..参数列表：" + Arrays.asList(args));
	}

	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature().getName() + "结束..");
	}

	@AfterReturning(value = "pointCut()", returning = "result")
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(joinPoint.getSignature().getName() + "返回..结果为：" + result);
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void logException(JoinPoint joinPoint, Throwable exception) {
		System.out.println(joinPoint.getSignature().getName() + "异常..异常为：" + exception);
	}
}
