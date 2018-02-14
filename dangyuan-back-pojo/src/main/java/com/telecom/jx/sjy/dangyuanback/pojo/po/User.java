package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;

/**
 * 用户
 */
public class User implements Serializable {

    private Long id;//主键
    private String accountName;//账户名,手机号
    private String userName;//真实姓名
    private String password;//密码Ad123@min,d3a4388accf317083f4d9dabda2f2c38
    private String gender;//性别,0表示女1,表示男
    private String salt;
    private String nation;//民族
    private String nativeplace;//籍贯
    private String birthday;//出生年月,格式:yyyy-MM 1996-09
    private String degree;//学历学位
    private String inpartyday;//入党年月,格式:yyyy-MM 1996-09
    private String job;//职务
    private String inandout;//调入、调出时间及单位
    private Float score;//积分
    private String branch;//所属支部

    private int unreadInfoCount = 0;//未读信息条数

    public User() {

    }

    @Override
    public String toString() {
        return "{id=" + id + ",accountName=" + accountName + ",userName=" + userName + ",password=" + password + ",gender=" + gender + ",salt=" + salt + ",native=" + nation + ",nativeplace=" + nativeplace + ",birthday=" + birthday + ",degree=" + degree + ",inpartyday=" + inpartyday + ",job=" + job + ",inandout=" + inandout + ",score=" + score + ",branch=" + branch + ",unreadInfoCount=" + unreadInfoCount +
                "}";
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInpartyday() {
        return inpartyday;
    }

    public void setInpartyday(String inpartyday) {
        this.inpartyday = inpartyday;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getInandout() {
        return inandout;
    }

    public void setInandout(String inandout) {
        this.inandout = inandout;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getUnreadInfoCount() {
        return unreadInfoCount;
    }

    public void setUnreadInfoCount(int unreadInfoCount) {
        this.unreadInfoCount = unreadInfoCount;
    }
}
