package com.gaoao.service.impl;

import com.gaoao.dao.UserDao;
import com.gaoao.dao.impl.UserDaoImpl;
import com.gaoao.domain.PageBean;
import com.gaoao.domain.User;
import com.gaoao.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.findUser(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean register(String username) {

        User user = userDao.findByUsername(username);
       /* if(user!=null){
            return false;
        }
        else {
            return true;

        }*/
        System.out.println(user);
       return user==null;

    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }


    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> map) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        if(currentPage<=0){
            currentPage=1;
        }
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);

        int total = userDao.findTotalCount(map);
        pageBean.setTotalCount(total);

        //记录开始记录的索引
        int start = (currentPage - 1) * rows;
        List<User> list = userDao.findBookByPage(start,rows,map);
        pageBean.setList(list);

        int totalPage = (total % rows) == 0 ? total / rows : (total / rows) + 1;
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }

    @Override
    public User findUserById(int uid) {
        return userDao.findUserById(uid);
    }

    @Override
    public void updateUser(User user) {
       userDao.updateUser(user);
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @Override
    public boolean delete(String[] uid) {
        boolean flag = false;
//        return bookDao.delete(bid);
        if(uid!=null&&uid.length>0){
            for (String i : uid) {
                userDao.delete(Integer.parseInt(i));//批量删除
            }
            flag=true;
        }
        return flag;
    }
}
