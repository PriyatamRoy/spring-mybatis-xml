package com.mycompany.service;

import java.util.List;

import com.mycompany.model.Book;
/**
 * 
 * @author Suman
 *
 */
public interface BookService { 
	Book findById(int bookId);

	List<Book> findAllBooks();

	void addBook(Book book);

//	void deleteBook(int bookId);
//	
//	void updateBook(Book book);
}
