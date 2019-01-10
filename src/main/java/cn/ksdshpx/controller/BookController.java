package cn.ksdshpx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.ksdshpx.service.BookService;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:53:27
 */
@Controller
public class BookController {
	@Autowired
	private BookService bookService;
}
