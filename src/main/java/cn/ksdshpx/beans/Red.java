package cn.ksdshpx.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author peng.x
 * @date 2019年1月8日 上午10:56:47
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware {
	private ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("传入的IOC容器：" + applicationContext);
		this.applicationContext = applicationContext;
	}

	public void setBeanName(String name) {
		System.out.println("bean的名字：" + name);
	}

	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String resolveStringValue = resolver.resolveStringValue("操作平台是${os.name},工号#{20*18}");
		System.out.println("解析后的字符串为：" + resolveStringValue);
	}

}
