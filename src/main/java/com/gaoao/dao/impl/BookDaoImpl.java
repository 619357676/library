package com.gaoao.dao.impl;

import com.gaoao.dao.BookDao;
import com.gaoao.domain.Book;
import com.gaoao.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookDaoImpl implements BookDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Book> findAll() {
        String sql = "select * from books";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));
    }

    @Override
    public boolean add(Book book) {
        String sql = "insert into books(name,author,pubDate,pubHouse,page,classify,CLC,introduction,num,loan) values(?,?,?,?,?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getPubDate(), book.getPubHouse(), book.getPage(), book.getClassify(), book.getClc(), book.getIntroduction(), book.getNum(), book.getLoan());
        return i == 1;
    }

    @Override
    public boolean delete(int bid) {
        String sql = "delete from books where bid=?";
        int update = jdbcTemplate.update(sql, bid);
        return update == 1;

    }

    @Override
    public List<Book> findBook() {
        String sql = "select * from books where 1==1";
        StringBuilder sb = new StringBuilder(sql);
        return null;

    }

    @Override
    public List<Book> findBookByPage(int start, int rows, Map<String, String[]> map) {

        String sql = "select * from books where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        //遍历map
        Set<String> keySet = map.keySet();

        //定义条件的参数

        List<Object> params = new ArrayList<Object>();

        for (String s : keySet) {
            if ("currentPage".equals(s) || "rows".equals(s)) {
                continue;
            }
            String value = map.get(s)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + s + " like ? ");
                params.add("%" + value + "%");
            }

            System.out.println(s);
        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
       /* System.out.println("sql语句：");
//        System.out.println(sb.toString());
        System.out.println(sql);
        System.out.println(params);*/

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), params.toArray());

    }


    @Override
    public int findTotalCount(Map<String, String[]> map) {
        String sql = "select count(*) from books where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        //遍历map
        Set<String> keySet = map.keySet();

        //定义条件的参数
        List<Object> params = new ArrayList<Object>();

        for (String s : keySet) {
            if ("currentPage".equals(s) || "rows".equals(s)) {
                continue;
            }
            String value = map.get(s)[0];
            if (value != null && !"".equals(value)) {
                sb.append(" and " + s + " like ? ");

                params.add("%" + value + "%");

            }
        }
        /*System.out.println("sql为：");
        System.out.println(sb.toString());
        System.out.println("参数");
        System.out.println(params);*/

        return jdbcTemplate.queryForObject(sb.toString(), Integer.class, params.toArray());

    }

    @Override
    public List<Book> findBookById(int bid) {
        String sql = "select * from books where bid = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class), bid);
    }

    /**
     * 修改
     * @param book
     */
    @Override
    public void updateBook(Book book) {
        String sql = "update books set name = ?,author = ?,pubDate = ?,pubHouse = ?,page = ?,classify = ?,clc = ?,introduction = ?,num=?,loan=? where bid = ?";
        jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getPubDate(), book.getPubHouse(), book.getPage(), book.getClassify(), book.getClc(), book.getIntroduction(), book.getNum(), book.getLoan(), book.getBid());
    }

    /**
     * 查找
     * @param bid
     * @return
     */
    @Override
    public Book findBookByBid(int bid) {
        String sql = "select * from books where bid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), bid);
    }


   /* @Override
    public boolean borrow(Book books) {
        String sql = "update books set loan=loan-1 where bid = ?";
        int update = jdbcTemplate.update(sql, books.getBid());

        return update == 1;
    }

    @Override
    public boolean returnBook(Book books) {
        String sql = "update books set loan=loan+1 where bid = ?";
        int update = jdbcTemplate.update(sql, books.getBid());

        return update == 1;
    }

    @Override
    public int findLoan(int bid) {
       *//* BookDao bookDao = new BookDaoImpl();
      return  bookDao.findBookByBid(bid).getLoan();*//*
        String sql = "select loan from books where bid = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, bid);

    }*/
}

