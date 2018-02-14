/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapper;

import com.mycompany.model.Book;
import java.util.List;

/**
 *
 * @author Suman
 */
public interface BookMapper {

    List<Book> getAll();
    Book selectBook(int id);
    void insertBook(Book book);
}
