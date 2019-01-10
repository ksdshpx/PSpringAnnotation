package cn.ksdshpx.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import cn.ksdshpx.config.MainConfigOfAutowired;
import cn.ksdshpx.dao.BookDao;
import cn.ksdshpx.service.BookService;;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:53
 */
public class IOCTestOfAutowired {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				MainConfigOfAutowired.class);
		BookService bookService = ctx.getBean("bookService",BookService.class);
		System.out.println(bookService);
		BookDao bookDao = ctx.getBean("bookDao",BookDao.class);
		System.out.println(bookDao);
	}
}
