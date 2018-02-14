package com.mycompany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.model.Book;
import com.mycompany.service.BookService;

/**
 * 
 * @author Suman
 *
 */

@Controller
public class RestController {  
	@Autowired
	private BookService bookService;      
	@RequestMapping(value = "/rest/getAllBook", method = RequestMethod.GET)
	public @ResponseBody List getAllBook() {
		System.out.println("#########getAllBook()#########");
		List<Book> bookList = bookService.findAllBooks();
		return bookList;
	}
	
	@RequestMapping(value = "/rest/addBook", method = RequestMethod.POST)
	public @ResponseBody String addBook(@RequestBody Book book) { 
		System.out.println("#########addBook()#########");
		bookService.addBook(book);
		return "OK";
	}
	
//	@RequestMapping(value = "/rest/updateBook", method = RequestMethod.POST)
//	public @ResponseBody String  updateBook(@RequestBody Book book) {
//		System.out.println("#########updateBook()#########");
//		bookService.updateBook(book); 
//		return "OK";
//	}
//	
//	@RequestMapping(value = "/rest/deleteBook", method = RequestMethod.POST)
//	public @ResponseBody String  deleteBook(@RequestBody Book book) {
//		System.out.println("#########deleteBook()#########");
//		bookService.deleteBook(book.getId());
//		return "OK";
//	}
}
