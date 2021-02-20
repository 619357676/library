package com.gaoao.dao;

import com.gaoao.domain.Book;
import com.gaoao.domain.Borrow;

import java.util.List;

public interface BorrowDao {
    boolean borrow(Book book);//借书
    boolean returnBook(Book book);//借书

    int findLoan(int bid);//查询可借数量

    boolean add(Borrow borrow);
    boolean add1(Borrow borrow);

    Borrow findBorrow(Borrow borrow);

    List<Borrow> findBorrowInfo(String id);

    List<Borrow> findBorrowInfoByIds(int id, int bid);

    List<Borrow> findWhether(Borrow borrow);
}
