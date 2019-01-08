package cn.ksdshpx.beans;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author peng.x
 * @date 2019年1月8日 下午2:11:01
 */
//创建一个Spring定义的FactoryBean
public class ColorFactoryBean implements FactoryBean<Color> {

	//返回一个Color对象，这个对象会添加到IOC容器中
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean..getObject()");
		return new Color();
	}

	public Class<?> getObjectType() {
		return Color.class;
	}

	public boolean isSingleton() {
		return false;
	}

}
