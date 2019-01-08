package cn.ksdshpx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import cn.ksdshpx.beans.Car;

/**
 * @author peng.x
 * @date 2019年1月8日 下午3:56:28
 */
@Configuration
public class MainConfigOfLifeCycle {
	/**
	 * 对象创建：
	 * 		单实例：IOC容器启动的时候创建对象
	 * 		多实例：每次获取的时候创建对象
	 * 
	 * 初始化：
	 * 		对象创建完成，并赋值好，调用初始化方法
	 * 
	 * 销毁：
	 * 		单实例：IOC容器关闭的时候
	 * 		多实例：IOC容器不会管理这个bean，即容器不会调用销毁方法
	 * 1)指定初始化和销毁方法
	 * 		通过@Bean指定init-method和destroy-method
	 */
	//@Scope("prototype")
	@Bean(initMethod="init",destroyMethod="destroy")
	public Car car() {
		return new Car();
	}
}
