package cn.ksdshpx.beans;
/**
 * @author peng.x
 * @date 2019年1月8日 下午4:01:15
 */
public class Car {
	public Car() {
		System.out.println("Car Constructor...");
	}
	
	public void init() {
		System.out.println("Car init...");
	}
	
	public void destroy() {
		System.out.println("Car destroy...");
	}
}
