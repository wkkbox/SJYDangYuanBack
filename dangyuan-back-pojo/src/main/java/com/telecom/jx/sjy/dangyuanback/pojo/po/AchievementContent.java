package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;
import java.util.List;

public class AchievementContent implements Serializable {

    private Long id;//主键
    private String content;//活动记录内容
    private Long userId;//活动记录所属用户id
    private Long arrangeId;//活动记录所属活动安排(例如党责安排)表id

    private Long userAchievementId;
    private List<ActivityAttachment> attachments;
    private Long achievementId;
    private Long achievement3Id;
    private Achievement achievement;
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


    public Long getUserAchievementId() {
        return userAchievementId;
    }

    public void setUserAchievementId(Long userAchievementId) {
        this.userAchievementId = userAchievementId;
    }

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public Long getAchievement3Id() {
        return achievement3Id;
    }

    public void setAchievement3Id(Long achievement3Id) {
        this.achievement3Id = achievement3Id;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }
}
