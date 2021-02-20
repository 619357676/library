package com.gaoao.dao;

import com.gaoao.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    List<Role> findAllRole();

    List<Map<String, Object>> findAllUserRole();
    List<Map<String, Object>> findRoleByUid(int uid);

    boolean updateRole(int uid, int rid);

    int findUserRoleByUid(int uid);
}
