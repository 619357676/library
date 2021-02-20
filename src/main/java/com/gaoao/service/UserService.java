package com.gaoao.service;


import com.gaoao.domain.User;
import com.gaoao.domain.PageBean;


import java.util.List;
import java.util.Map;

public interface UserService {

    User login(User user);

    boolean register(String username);

    void save(User user);

    List<User> findAll();

    PageBean<User> findUserByPage(String currentPage, String rows, Map<String,String[]> map);

    User findUserById(int uid);

    void updateUser(User user);

    boolean add(User user);

    boolean delete(String[] uid);
}

