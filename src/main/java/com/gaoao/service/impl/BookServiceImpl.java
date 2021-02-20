package com.gaoao.service.impl;

import com.gaoao.dao.BookDao;
import com.gaoao.dao.impl.BookDaoImpl;
import com.gaoao.domain.Book;
import com.gaoao.domain.PageBean;
import com.gaoao.service.BookService;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public boolean add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public boolean delete(String[] bid) {
        boolean flag = false;
//        return bookDao.delete(bid);
        if(bid!=null&&bid.length>0){
            for (String i : bid) {
               bookDao.delete(Integer.parseInt(i));

            }
            flag=true;
        }
        return flag;
    }

    @Override
    public PageBean<Book> findBookByPage(String _currentPage, String _rows, Map<String,String[]> map) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if(currentPage<=0){
            currentPage=1;
        }
        PageBean<Book> pageBean = new PageBean<Book>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        int total = bookDao.findTotalCount(map);
        pageBean.setTotalCount(total);

        //记录开始记录的索引
        int start = (currentPage - 1) * rows;
        List<Book> list = bookDao.findBookByPage(start,rows,map);
        pageBean.setList(list);

        int totalPage = (total % rows) == 0 ? total / rows : (total / rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;

    }

    @Override
    public List<Book> findBookById(int bid) {
        return bookDao.findBookById(bid);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book findBookByBid(int bid) {
        return bookDao.findBookByBid(bid);
    }




}
