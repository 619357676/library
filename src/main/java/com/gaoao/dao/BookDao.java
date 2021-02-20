package com.gaoao.dao;

import com.gaoao.domain.Book;

import java.util.List;
import java.util.Map;

public interface BookDao {

    List<Book> findAll();//查询所有书
    boolean add(Book book);//添加书
    boolean delete(int bid);//删除书

    List<Book> findBook();
    List<Book> findBookByPage(int currentPage, int rows, Map<String,String[]> map);

    int findTotalCount(Map<String,String[]> map);

    List<Book> findBookById(int bid);

    void updateBook(Book book);

    Book findBookByBid(int bid);

    /*boolean borrow(Book books);//借书
    boolean returnBook(Book books);//借书

    int findLoan(int bid);//查询可借数量
*/
}
