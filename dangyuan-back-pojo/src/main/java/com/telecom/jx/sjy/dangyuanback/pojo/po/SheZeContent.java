package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;
import java.util.List;

public class SheZeContent implements Serializable {

    private Long id;//主键
    private String content;//活动记录内容
    private Long userId;//活动记录所属用户id
    private Long arrangeId;//活动记录所属活动安排(例如党责安排)表id

    private Long userShezeId;
    private List<ActivityAttachment> attachments;
    private Long shezeId;
    private Long sheze3Id;
    private SheZe sheZe;
    private User user;
    private String commitTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArrangeId() {
        return arrangeId;
    }

    public void setArrangeId(Long arrangeId) {
        this.arrangeId = arrangeId;
    }

    public List<ActivityAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<ActivityAttachment> attachments) {
        this.attachments = attachments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(String commitTime) {
        this.commitTime = commitTime;
    }

    @Override
    public String toString() {
        return "{ id=" + id + ",content=" + content + ",userId=" + userId + ",arrangeId=" + arrangeId + " }";
    }


    public Long getUserShezeId() {
        return userShezeId;
    }

    public void setUserShezeId(Long userShezeId) {
        this.userShezeId = userShezeId;
    }

    public Long getShezeId() {
        return shezeId;
    }

    public void setShezeId(Long shezeId) {
        this.shezeId = shezeId;
    }

    public Long getSheze3Id() {
        return sheze3Id;
    }

    public void setSheze3Id(Long sheze3Id) {
        this.sheze3Id = sheze3Id;
    }

    public SheZe getSheZe() {
        return sheZe;
    }

    public void setSheZe(SheZe sheZe) {
        this.sheZe = sheZe;
    }
}
