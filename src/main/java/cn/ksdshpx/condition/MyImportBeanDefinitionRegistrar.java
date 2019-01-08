package cn.ksdshpx.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import cn.ksdshpx.beans.RainBow;

/**
 * @author peng.x
 * @date 2019年1月8日 下午1:57:44
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		boolean definition = registry.containsBeanDefinition("cn.ksdshpx.beans.Blue");
		boolean definition2 = registry.containsBeanDefinition("cn.ksdshpx.beans.Red");
		if (definition && definition2) {
			RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
			registry.registerBeanDefinition("rainBow", beanDefinition);
		}
	}
}
