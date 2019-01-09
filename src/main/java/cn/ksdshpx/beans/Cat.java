package cn.ksdshpx.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author peng.x
 * @date 2019年1月9日 上午9:59:41
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

	public Cat() {
		System.out.println("Cat Constructor...");
	}

	public void destroy() throws Exception {
		System.out.println("Cat destroy...");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Cat afterPropertiesSet...");
	}

}
