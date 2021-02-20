package com.gaoao.service.impl;

import com.gaoao.dao.RoleDao;
import com.gaoao.dao.impl.RoleDaoImpl;
import com.gaoao.domain.Role;
import com.gaoao.service.RoleService;

import java.util.List;
import java.util.Map;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao = new RoleDaoImpl();
    @Override
    public List<Role> findAllRole() {

        return roleDao.findAllRole();
    }

    @Override
    public List<Map<String, Object>> findAllUserRole() {
        return roleDao.findAllUserRole();
    }
    @Override
    public List<Map<String, Object>> findRoleByUid(int uid) {
        return roleDao.findRoleByUid(uid);
    }

    @Override
    public int findUserRoleByUid(int uid) {
        return roleDao.findUserRoleByUid(uid);
    }

    @Override
    public boolean updateRole(int uid, int rid) {
        return roleDao.updateRole(uid,rid);
    }


}
