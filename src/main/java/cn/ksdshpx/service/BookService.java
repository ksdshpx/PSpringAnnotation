package cn.ksdshpx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cn.ksdshpx.dao.BookDao;

/**
 * @author peng.x
 * @date 2019年1月7日 下午4:54:12
 */
@Service
public class BookService {
	@Qualifier("bookDao")
	@Autowired(required=false)
	private BookDao bookDao;

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}
	
}
