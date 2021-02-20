package com.gaoao.service.impl;

import com.gaoao.dao.MenuDao;
import com.gaoao.dao.impl.MenuDaoImpl;
import com.gaoao.domain.Menu;
import com.gaoao.service.MenuService;

import java.util.List;
import java.util.Map;

public class MenuServiceImpl implements MenuService {
    private MenuDao menuDao = new MenuDaoImpl();
    @Override
    public List<Menu> findAllMenu() {
        return menuDao.findAllMenu();
    }

    @Override
    public List<Menu> findAllMenuByRid(String rid) {
        return menuDao.findAllMenuByRid(Integer.parseInt(rid));
    }


    @Override
    public void updatePrivilege(String rid,String[] mid) {
        for (int i = 0; i < mid.length; i++) {
            menuDao.updateMenuByRoleId(Integer.parseInt(rid),Integer.parseInt(mid[i]));
        }
    }

    @Override
    public boolean deletePrivilegeByRid(int rid) {

       return menuDao.deleteMenuByRid(rid);
    }

    @Override
    public List<Map<String, Object>> findMenuByUid(int uid) {
        return menuDao.findMenuByUid(uid);
    }


}
