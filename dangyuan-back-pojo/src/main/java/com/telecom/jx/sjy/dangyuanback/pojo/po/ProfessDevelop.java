package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;

/**
 * 专业提升实体
 */
public class ProfessDevelop implements Serializable {

    private Long id;//主键
    private String title;//专业提升标题
    private String content;//专业提升内容
    private String year;//年份
    private String publishTime;//管理员发布专业提升时间
    private Long roleId;//所属用户角色
    private Integer dScore;//固定得分，1，2，3...
    private Integer lScore;//最低得分
    private Integer hScore;//最高得分
    private Integer rate;//活动频率，0表示每月一次，1表示每季度一次，2表示每年一次，3表示不限次数
    private Integer otherAttr;//其他属性，1表示国家级，2表示省部级，3表示地市级，4表示集团（中央企业）级，5表示省公司级，6表示市公司级
    private Integer sumScore;//累计可得最高分

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getdScore() {
        return dScore;
    }

    public void setdScore(Integer dScore) {
        this.dScore = dScore;
    }

    public Integer getlScore() {
        return lScore;
    }

    public void setlScore(Integer lScore) {
        this.lScore = lScore;
    }

    public Integer gethScore() {
        return hScore;
    }

    public void sethScore(Integer hScore) {
        this.hScore = hScore;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getSumScore() {
        return sumScore;
    }

    public void setSumScore(Integer sumScore) {
        this.sumScore = sumScore;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getOtherAttr() {
        return otherAttr;
    }

    public void setOtherAttr(Integer otherAttr) {
        this.otherAttr = otherAttr;
    }
}
