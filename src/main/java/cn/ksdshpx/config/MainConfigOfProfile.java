package cn.ksdshpx.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author peng.x
 * @date 2019年1月10日 下午2:00:46 
 * Profile: Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 * 
 * 开发环境、测试环境、生产环境（切换数据源为例）
 *       
 * @Profile:指定组件在哪个环境的情况下才能被注册到容器中，不指定，任何环境下都能注册这个组件
 * 		1.加了环境标识的bean,只有这个环境被激活的时候才能注册到容器中。默认是default
 * 			使用命令行动态参数：在虚拟机参数位置加载-Dspring.profiles.active=环境标识
 * 			使用代码方式：ctx.getEnvironment().setActiveProfiles("test","dev");
 * 		
 * 		2.卸载配置类上，只有是指定环境的时候，整个配置类里面的所有配置才能开始生效
 * 
 * 		3.没有标注环境标识的bean在任何环境下都是加载的
 */
@PropertySource({ "classpath:/dbconfig.properties" })
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
	@Value("${db.user}")
	private String user;

	private StringValueResolver resolver;

	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("${db.password}") String password) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		String driverClass = resolver.resolveStringValue("${db.driverClass}");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Profile("dev")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("${db.password}") String password) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1");
		String driverClass = resolver.resolveStringValue("${db.driverClass}");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Profile("pro")
	@Bean("proDataSource")
	public DataSource dataSourcePro(@Value("${db.password}") String password) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/customers");
		String driverClass = resolver.resolveStringValue("${db.driverClass}");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.resolver = resolver;
	}

}
