package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;

/**
 * 消息
 */
public class Info implements Serializable{
    private Long id;//主键
    private String title;//标题
    private String content;//内容
    private String publishtime;//发布时间
    private Integer state = 0;//未读是0，已读是1，默认为0未读
    private Long roleId;//所属用户角色

    public Info(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
