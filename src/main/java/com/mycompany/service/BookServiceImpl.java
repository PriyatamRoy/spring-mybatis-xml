package com.mycompany.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.mapper.BookMapper;
import com.mycompany.model.Book;
/**
 * 
 * @author Suman
 *
 */
@Service
@Transactional
public class BookServiceImpl implements BookService { 

	@Autowired
	private BookMapper bookMapper;

	@Override
	public Book findById(int bookId) { 

		return bookMapper.selectBook(bookId);
	}

	@Override
	
	public List<Book> findAllBooks() {
		return bookMapper.getAll();
	}

	@Override

	public void addBook(Book book) {
		bookMapper.insertBook(book);

	}
}
