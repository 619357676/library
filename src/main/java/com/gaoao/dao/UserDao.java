package com.gaoao.dao;



import com.gaoao.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User login();

    User findUser(String username, String password);

    User findByUsername(String username);

    void save(User user);//保存用户

    List<User> findAll();//查询所有用户

    int findTotalCount(Map<String,String[]> map);

    List<User> findBookByPage(int currentPage, int rows, Map<String,String[]> map);

    User findUserById(int uid);

    void updateUser(User user);

    boolean add(User user);

    boolean delete(int i);




}
