package com.gaoao.dao.impl;

import com.gaoao.dao.MenuDao;
import com.gaoao.domain.Menu;
import com.gaoao.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class MenuDaoImpl implements MenuDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    //查找角色对应的权限
    @Override
    public List<Menu> findAllMenuByRid(int rid) {
        String sql = "SELECT menu.id, menu_name,menu.url,menu.desc FROM menu, role_menu_emp WHERE menu.id = role_menu_emp.mid AND role_menu_emp.rid=?;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Menu>(Menu.class),rid);
    }
    //查询所有存在的权限
    @Override
    public List<Menu> findAllMenu() {
        String sql = "SELECT * from menu";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Menu>(Menu.class));
    }

    @Override
    public void updateMenuByRoleId(int rid,int  mid) {

        String sql = "insert into role_menu_emp(rid,mid) values(?,?)";
        jdbcTemplate.update(sql,rid,mid);
    }


    @Override
    public boolean deleteMenuByRid(int rid) {
        String sql = "delete from role_menu_emp where rid = ?";
        int update = jdbcTemplate.update(sql, rid);
        return update==1;
    }

    @Override
    public List<Map<String,Object>> findMenuByUid(int uid) {
        String sql = "SELECT mid FROM role_menu_emp WHERE rid IN (SELECT rid FROM user_role_emp WHERE uid = ?)";
         return jdbcTemplate.queryForList(sql, uid);

    }

}
