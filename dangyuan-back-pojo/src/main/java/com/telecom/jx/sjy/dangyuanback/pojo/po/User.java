package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;

/**
 * 用户实体
 */
public class User implements Serializable {

    private Long id;//主键
    private String accountName;//账户名,手机号
    private String userName;//真实姓名
    private String password;//密码Ad123@min,d3a4388accf317083f4d9dabda2f2c38
    private String gender;//性别,0表示女,1表示男
    private String salt;
    private String nation;//民族
    private String nativeplace;//籍贯
    private String birthday;//出生年月,格式:yyyy-MM 1996-09
    private String degree;//文化程度
    private String inworkday;//参加工作时间
    private String inpartyday;//入党年月,格式:yyyy-MM 1996-09
    private String partDuties;//党内职务
    private String administrativeDuties;//行政职务
    private String profession;//职业
    private String positional;//职称
    private String idCard;//身份证号
    private String inandout;//离退，退职，内退时间
    private Integer score;//积分
    private String branch;//所属支部
    private Integer isFormal;//是正式还是预备党员，0表示预备党员，1表示正式党员
    private Integer isWork;//是否在岗，0表示离职，1表示在岗

    private int unreadInfoCount = 0;//未读信息条数

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getInworkday() {
        return inworkday;
    }

    public void setInworkday(String inworkday) {
        this.inworkday = inworkday;
    }

    public String getInpartyday() {
        return inpartyday;
    }

    public void setInpartyday(String inpartyday) {
        this.inpartyday = inpartyday;
    }

    public String getPartDuties() {
        return partDuties;
    }

    public void setPartDuties(String partDuties) {
        this.partDuties = partDuties;
    }

    public Integer getIsWork() {
        return isWork;
    }

    public void setIsWork(Integer isWork) {
        this.isWork = isWork;
    }

    public Integer getIsFormal() {
        return isFormal;
    }

    public void setIsFormal(Integer isFormal) {
        this.isFormal = isFormal;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getInandout() {
        return inandout;
    }

    public void setInandout(String inandout) {
        this.inandout = inandout;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPositional() {
        return positional;
    }

    public void setPositional(String positional) {
        this.positional = positional;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getAdministrativeDuties() {
        return administrativeDuties;
    }

    public void setAdministrativeDuties(String administrativeDuties) {
        this.administrativeDuties = administrativeDuties;
    }

    public int getUnreadInfoCount() {
        return unreadInfoCount;
    }

    public void setUnreadInfoCount(int unreadInfoCount) {
        this.unreadInfoCount = unreadInfoCount;
    }
}
