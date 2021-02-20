package com.gaoao.service;

import com.gaoao.domain.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {
    List<Menu> findAllMenu();

    List<Menu> findAllMenuByRid(String rid);

    void updatePrivilege(String rid ,String[] id);

    boolean deletePrivilegeByRid(int rid);

    List<Map<String, Object>> findMenuByUid(int uid);
}
