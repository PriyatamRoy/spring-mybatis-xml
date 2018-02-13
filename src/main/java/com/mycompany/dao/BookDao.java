package com.mycompany.dao;

import java.util.List;

import com.mycompany.model.Book;
/**
 * 
 * @author Hamidul Islam
 *
 */
public interface BookDao {

	Book findById(int bookId);

	List<Book> findAllBooks();

	void addBook(Book book);

	void deleteBook(int bookId);
	
	void updateBook(Book book);

}
