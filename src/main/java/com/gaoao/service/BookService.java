package com.gaoao.service;

import com.gaoao.domain.Book;
import com.gaoao.domain.PageBean;

import java.util.List;
import java.util.Map;


public interface BookService {
    List<Book> findAll();
    boolean add(Book book);
    boolean delete(String[] bid);
    PageBean<Book> findBookByPage(String currentPage, String rows, Map<String,String[]> map);

    List<Book> findBookById(int bid);

    void updateBook(Book book);

    Book findBookByBid(int bid);

  /*  boolean borrow(Book books);
    boolean returnBook(Book books);*/
}
