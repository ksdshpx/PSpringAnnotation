package cn.ksdshpx.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author peng.x
 * @date 2019年1月10日 下午2:00:46 Profile: Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 * 
 *       开发环境、测试环境、生产环境（切换数据源为例）
 */
@PropertySource({ "classpath:/dbconfig.properties" })
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {
	@Value("${db.user}")
	private String user;

	private StringValueResolver resolver;

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
