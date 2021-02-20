package com.gaoao.service.impl;

import com.gaoao.dao.BorrowDao;
import com.gaoao.dao.impl.BorrowDaoImpl;
import com.gaoao.domain.Book;
import com.gaoao.domain.Borrow;
import com.gaoao.service.BorrowService;

import java.util.List;

public class BorrowServiceImpl implements BorrowService {
    private BorrowDao borrowDao = new BorrowDaoImpl();
    //借书
    @Override
    public boolean borrow(Book book) {
        int i = borrowDao.findLoan(book.getBid());
        return i > 0 &&borrowDao.borrow(book);
    }
    //还书
    @Override
    public boolean returnBook(Book book) {

        return borrowDao.returnBook(book);
    }

    @Override
    public boolean add(Borrow borrow) {
        return borrowDao.add(borrow);
    }
    @Override
    public boolean add1(Borrow borrow) {

        return borrowDao.add1(borrow);
    }

    @Override
    public Borrow findBorrow(Borrow borrow) {
        return borrowDao.findBorrow(borrow);
    }

    @Override
    public List<Borrow> findBorrowInfo(String uid) {
        return borrowDao.findBorrowInfo(uid);
    }
    @Override
    public List<Borrow> findBorrowInfoByIds(int id,int bid) {
        return borrowDao.findBorrowInfoByIds(id,bid);
    }

    @Override
    public List<Borrow> findWhether(Borrow borrow) {
        return borrowDao.findWhether(borrow);
    }
}
