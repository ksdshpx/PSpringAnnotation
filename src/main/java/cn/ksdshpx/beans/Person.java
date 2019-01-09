package cn.ksdshpx.beans;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:13:03
 */
public class Person {
	/**
	 * 使用@Value赋值
	 * 1.基本数值
	 * 2.SpEL表达式
	 * 3.可以写${}:取出配置文件中的值（在运行环境变量里面的值）
	 */
	@Value("zhangSan")
	private String name;
	@Value("#{20-5}")
	private Integer age;

	public Person() {
		super();
	}

	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
