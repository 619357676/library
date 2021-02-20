package com.gaoao.dao.impl;


import com.gaoao.dao.UserDao;
import com.gaoao.domain.User;
import com.gaoao.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User login() {
        return null;
    }

    @Override
    public User findUser(String username, String password) {
        User user = null;
        try {
            String sql = "SELECT * from user where username = ? and password = ?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
        } catch (Exception e) {

        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            String sql = "SELECT * from user where username=?";
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);

        } catch (Exception e) {

        }
//        System.out.println("请求的sql:"+sql);
        return user;
    }

    @Override
    public void save(User user) {
        String sql = "insert into user(username,password,email,name,tel,sex) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getTel(), user.getSex());

    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public int findTotalCount(Map<String, String[]> map) {
        String sql = "select count(*) from user where 1 = 1";
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
    public List<User> findBookByPage(int start, int rows, Map<String, String[]> map) {
        String sql = "select * from user where 1 = 1";
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
        System.out.println("sql语句：");
//        System.out.println(sb.toString());
        System.out.println(sql);
        System.out.println(params);

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());

    }

    @Override
    public User findUserById(int uid) {
        String sql = "select * from user where uid = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), uid);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set username = ?,password = ?,email = ?,name = ?,tel = ?,sex = ?where uid = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getTel(), user.getSex(), user.getUid());
    }

    @Override
    public boolean add(User user) {

        String sql = "insert into user(username,password,email,name,tel,sex) values(?,?,?,?,?,?)";
        int i = jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getTel(), user.getSex());
        return i == 1;
    }

    @Override
    public boolean delete(int uid) {
        String sql = "delete from user where uid=?";
        int update = jdbcTemplate.update(sql, uid);
        return update == 1;
    }


/* @Override
    public void login(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/grad?&useSSL=false&serverTimezone=UTC","root","000000");
            String sql="SELECT * from user";
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                int id=rs.getInt("id");
                String username=rs.getString("username");
                String password=rs.getString("password");

                System.out.println("id:"+id+" username:"+username+" password:"+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

   /* @Override
    public boolean findUser(String username,String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grad?&useSSL=false&serverTimezone=UTC", "root", "000000");
            String sql = "SELECT * from user WHERE username=? AND password=?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
//            rs=stmt.executeQuery(sql);
            *//*while(rs.next()){
                int id=rs.getInt("id");
               *//**//* String username=rs.getString("username");
                String password=rs.getString("password");*//**//*

                System.out.println("id:"+id+" username:"+username+" password:"+password);
            }*//*
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }*/
}


