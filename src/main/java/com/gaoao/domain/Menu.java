package com.gaoao.domain;

public class Menu {
    private int id;
    private String menu_name;
    private String url;
    private String desc;

    public Menu() {
    }

    public Menu(int id, String menu_name, String url, String desc) {
        this.id = id;
        this.menu_name = menu_name;
        this.url = url;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menu_name='" + menu_name + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
