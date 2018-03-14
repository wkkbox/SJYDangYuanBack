package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;
import java.util.List;

public class HonorsAwardContent implements Serializable {

    private Long id;//主键
    private String content;//活动记录内容
    private Long userId;//活动记录所属用户id
    private Long arrangeId;//活动记录所属活动安排(例如党责安排)表id

    private Long userHonorsAwardId;
    private List<ActivityAttachment> attachments;
    private Long honorsAwardId;
    private Long honorsAward3Id;
    private HonorsAward honorsAward;
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


    public Long getUserHonorsAwardId() {
        return userHonorsAwardId;
    }

    public void setUserHonorsAwardId(Long userHonorsAwardId) {
        this.userHonorsAwardId = userHonorsAwardId;
    }

    public Long getHonorsAwardId() {
        return honorsAwardId;
    }

    public void setHonorsAwardId(Long honorsAwardId) {
        this.honorsAwardId = honorsAwardId;
    }

    public Long getHonorsAward3Id() {
        return honorsAward3Id;
    }

    public void setHonorsAward3Id(Long honorsAward3Id) {
        this.honorsAward3Id = honorsAward3Id;
    }

    public HonorsAward getHonorsAward() {
        return honorsAward;
    }

    public void setHonorsAward(HonorsAward honorsAward) {
        this.honorsAward = honorsAward;
    }
}
