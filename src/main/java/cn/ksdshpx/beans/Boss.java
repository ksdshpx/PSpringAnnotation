package cn.ksdshpx.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author peng.x
 * @date 2019年1月10日 上午10:39:34
 */
//默认加在IOC容器中的组件，容器启动会调用无参构造器创建对象再进行初始化赋值操作
@Component
public class Boss {
	private Car car;

	/**
	 * 构造器需要的组件，都是从IOC容器中获取
	 */
	@Autowired
	public Boss(Car car) {
		super();
		System.out.println("Boss的有参构造器...");
		this.car = car;
	}
	
	/*
	public Boss(@Autowired Car car) {
		super();
		System.out.println("Boss的有参构造器...");
		this.car = car;
	}
	*/

	public Car getCar() {
		return car;
	}

	/**
	 * @Autowired标注在方法上，Spring容器创建当前对象，就会调用方法，完成赋值 方法使用的参数，自定义类型的值从IOC容器中获取
	 */
	//@Autowired
	public void setCar(Car car) {
		this.car = car;
	}
	
	/*
	public void setCar(@Autowired Car car) {
		this.car = car;
	}
	*/

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}

}
