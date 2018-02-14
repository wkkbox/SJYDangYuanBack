package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;

/**
 * 党责
 */
public class DangZe implements Serializable {

    private Long id;//主键
    private String title;//党责标题
    private String content;//党责内容
    private String scoreRule;//积分规则
    private Integer state = 0;//申请是0，申请中是1，完成是2，默认申请为0
    private String publishtime;//发布时间
    private String endtime;//结束时间
    private Long roleId;//所属用户角色

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

    public String getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(String publishtime) {
        this.publishtime = publishtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getScoreRule() {
        return scoreRule;
    }

    public void setScoreRule(String scoreRule) {
        this.scoreRule = scoreRule;
    }
}
