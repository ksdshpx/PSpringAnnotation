package cn.ksdshpx.test;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.ksdshpx.config.MainConfigOfProfile;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTestOfProfile {
	public static void main(String[] args) {
		//1.创建一个IOC容器
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//2.设置需要激活的环境
		ctx.getEnvironment().setActiveProfiles("test","dev");
		//3.注册主配置类
		ctx.register(MainConfigOfProfile.class);
		//4.容器刷新
		ctx.refresh();
		String[] beanNamesForType = ctx.getBeanNamesForType(DataSource.class);
		for (String beanName : beanNamesForType) {
			System.out.println(beanName);
		}
	}
}
