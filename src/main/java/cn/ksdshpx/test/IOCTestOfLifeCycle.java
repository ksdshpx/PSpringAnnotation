package cn.ksdshpx.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.ksdshpx.config.MainConfigOfLifeCycle;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTestOfLifeCycle {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("容器创建完成...");
		ctx.close();
	}
}
