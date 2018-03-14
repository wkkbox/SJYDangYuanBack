package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;
import java.util.List;

public class DangZeContent implements Serializable {

    private Long id;//主键
    private String content;//活动记录内容
    private Long userId;//活动记录所属用户id
    private Long arrangeId;//活动记录所属活动安排(例如党责安排)表id

    private Long userDangzeId;
    private List<ActivityAttachment> attachments;
    private Long dangzeId;
    private Long dangze3Id;
    private DangZe dangZe;
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

    public Long getUserDangzeId() {
        return userDangzeId;
    }

    public void setUserDangzeId(Long userDangzeId) {
        this.userDangzeId = userDangzeId;
    }

    public List<ActivityAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<ActivityAttachment> attachments) {
        this.attachments = attachments;
    }

    public Long getDangzeId() {
        return dangzeId;
    }

    public void setDangzeId(Long dangzeId) {
        this.dangzeId = dangzeId;
    }

    public Long getDangze3Id() {
        return dangze3Id;
    }

    public void setDangze3Id(Long dangze3Id) {
        this.dangze3Id = dangze3Id;
    }

    public DangZe getDangZe() {
        return dangZe;
    }

    public void setDangZe(DangZe dangZe) {
        this.dangZe = dangZe;
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


}
