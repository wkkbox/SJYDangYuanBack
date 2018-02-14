package com.telecom.jx.sjy.dangyuanback.util.dto;

public class Menu {

    private String menuName;//例如修改用户
    private String menuUrl;//例如/user/updateUser

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
