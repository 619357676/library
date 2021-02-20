package com.gaoao.dao.impl;

import com.gaoao.dao.BorrowDao;
import com.gaoao.domain.Book;
import com.gaoao.domain.Borrow;
import com.gaoao.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BorrowDaoImpl implements BorrowDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    //借阅书籍减1
    //事务
    @Override
    public boolean borrow(Book book) {
        String sql = "update books set loan=loan-1 where bid = ?";
        int update = jdbcTemplate.update(sql, book.getBid());

        return update == 1;
    }

    //还书,进行两个操作
    @Override
    public boolean returnBook(Book book) {
        String sql = "update books set loan=loan+1 where bid = ?";
        int update = jdbcTemplate.update(sql, book.getBid());
        return update == 1;
    }

    @Override
    public int findLoan(int bid) {
        String sql = "select loan from books where bid = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, bid);

    }

    //借书时添加借阅信息
    //事务
    @Override
    public boolean add(Borrow borrow) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());

        String sql= "insert into borrow(uid,bid,borrowTime) values(?,?,?)";
        int update = jdbcTemplate.update(sql, borrow.getUid(), borrow.getBid(),format);
        return update==1;
    }

    //添加还书信息

    @Override
    public boolean add1(Borrow borrow) {
        String sql1= "update borrow set returnTime = ? where record = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        int update = jdbcTemplate.update(sql1, format, borrow.getRecord());
        return update==1;
    }

    //查询借阅记录
    @Override
    public Borrow findBorrow(Borrow borrow) {
        String sql = "SELECT * FROM borrow WHERE uid = ? AND bid = ? AND borrowTime IS NOT NULL AND returnTime IS NULL";
       return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Borrow>(Borrow.class),borrow.getUid(),borrow.getBid());
    }

    @Override
    public List<Borrow> findBorrowInfo(String uid) {
        String sql = "select * from borrow where uid = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Borrow>(Borrow.class),uid);

    }
    @Override
    public List<Borrow> findBorrowInfoByIds(int uid,int bid) {
        String sql = "select * from borrow where uid = ? and bid = ?";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Borrow>(Borrow.class),uid,bid);

    }
//可还的记录,即不可借的记录     已借过未还
    @Override
    public List<Borrow> findWhether(Borrow borrow) {
        String sql = "select * from borrow where uid = ? and bid = ? and borrowTime IS NOT NULL AND returnTime IS NULL";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Borrow>(Borrow.class), borrow.getUid(),borrow.getBid());

    }


}
