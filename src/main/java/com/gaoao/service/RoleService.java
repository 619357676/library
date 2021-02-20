package com.gaoao.service;

import com.gaoao.domain.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Role> findAllRole();

    List<Map<String, Object>>findAllUserRole();
    List<Map<String, Object>>findRoleByUid(int uid);
    int findUserRoleByUid(int uid);

    boolean updateRole(int uid, int rid);

}
