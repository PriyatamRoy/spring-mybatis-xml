package com.mycompany.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.model.Book;

/**
 * 
 * @author Hamidul Islam
 *
 */
@Repository

public class BookDaoImpl implements BookDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public Book findById(int bookId) {
		Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, bookId);
		return book;
	}

	@Override
	public List<Book> findAllBooks() {
		 return sessionFactory.getCurrentSession().createQuery("from Book b order by b.createDate desc").list(); 
	}

	@Override
	public void addBook(Book book) {
		long id = (long)sessionFactory.getCurrentSession().save(book);
                System.out.println("================>> " + id);
		
	}

	@Override
	public void deleteBook(int bookId) {
		Book book = (Book) sessionFactory.getCurrentSession().load(Book.class, bookId); 
        if (null != book) {
            sessionFactory.getCurrentSession().delete(book);
        }
		
	}

	@Override
	public void updateBook(Book book) {
		sessionFactory.getCurrentSession().update(book);
		
	}

}
