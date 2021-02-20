package com.gaoao.dao;

import com.gaoao.domain.Menu;

import java.util.List;
import java.util.Map;

public interface MenuDao {
    List<Menu> findAllMenuByRid(int rid);
    List<Menu> findAllMenu();

    void updateMenuByRoleId(int rid,int mid);


    boolean deleteMenuByRid(int rid);

    List<Map<String,Object>> findMenuByUid(int uid);

}
