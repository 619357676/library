package com.gaoao.service;

import com.gaoao.domain.Book;
import com.gaoao.domain.Borrow;

import java.util.List;

public interface BorrowService {
    boolean borrow(Book book);
    boolean returnBook(Book book);
    boolean add(Borrow borrow);
    boolean add1(Borrow borrow);
    Borrow findBorrow(Borrow borrow);

    List<Borrow> findBorrowInfo(String id);

    List<Borrow> findBorrowInfoByIds(int id, int bid);

    List<Borrow> findWhether(Borrow borrow);

}
