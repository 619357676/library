package com.gaoao.domain;

public class Role {
    private int id;
    private String role_name;
    private String role_desc;

    public Role() {
    }

    public Role(int id, String role_name, String role_desc) {
        this.id = id;
        this.role_name = role_name;
        this.role_desc = role_desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_desc='" + role_desc + '\'' +
                '}';
    }
}
