package com.telecom.jx.sjy.dangyuanback.pojo.vo;

import java.io.Serializable;

/**
 * 积分实体
 */
public class Score implements Serializable {

    private Long id;//主键
    private String userName;//真实姓名
    private String gender;//性别,0表示女1,表示男
    private Float score;//积分
    private String branch;//所属支部

    public Score() {

    }

    @Override
    public String toString() {
        return "{id=" + id + ",userName=" + userName + ",gender=" + gender + ",score=" + score + ",branch=" + branch + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


}
