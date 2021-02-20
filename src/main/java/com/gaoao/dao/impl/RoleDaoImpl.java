package com.gaoao.dao.impl;

import com.gaoao.dao.RoleDao;
import com.gaoao.domain.Role;
import com.gaoao.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class RoleDaoImpl implements RoleDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Role> findAllRole() {
        String sql = "select * from role";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));

    }

    @Override
    public List<Map<String, Object>> findAllUserRole() {
        String sql = "SELECT user.uid , user.username , user.name , role_name , role_desc FROM user_role_emp,USER,role WHERE user_role_emp.uid = user.uid AND user_role_emp.rid = role.id;";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> findRoleByUid(int uid) {
        String sql = "SELECT user_role_emp.rid , user.username , user.name , role_name  FROM user_role_emp,USER,role WHERE user_role_emp.uid = user.uid  AND user_role_emp.rid = role.id AND user.uid = ?";
        return jdbcTemplate.queryForList(sql, uid);
    }

    @Override
    public boolean updateRole(int uid, int rid) {
        String sql = "update user_role_emp set rid = ? where uid = ?";
        int update = jdbcTemplate.update(sql, rid, uid);
        return update == 1;
    }

    @Override
    public int findUserRoleByUid(int uid) {
        String sql = "select rid from user_role_emp where uid = ?";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class, uid);
        if (integer != null) {
            return integer;
        } else return 0;

        //“Integer是包装类,是对象,是可以为Null的”
    }
}
