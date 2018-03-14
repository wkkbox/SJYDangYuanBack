package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;
import java.util.List;

public class ProfessDevelopContent implements Serializable {

    private Long id;//主键
    private String content;//活动记录内容
    private Long userId;//活动记录所属用户id
    private Long arrangeId;//活动记录所属活动安排(例如党责安排)表id

    private Long userProfessDevelopId;
    private List<ActivityAttachment> attachments;
    private Long professdevelopId;
    private Long professdevelop3Id;
    private ProfessDevelop professDevelop;
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


    public Long getUserProfessDevelopId() {
        return userProfessDevelopId;
    }

    public void setUserProfessDevelopId(Long userProfessDevelopId) {
        this.userProfessDevelopId = userProfessDevelopId;
    }

    public Long getProfessdevelopId() {
        return professdevelopId;
    }

    public void setProfessdevelopId(Long professdevelopId) {
        this.professdevelopId = professdevelopId;
    }

    public Long getProfessdevelop3Id() {
        return professdevelop3Id;
    }

    public void setProfessdevelop3Id(Long professdevelop3Id) {
        this.professdevelop3Id = professdevelop3Id;
    }

    public ProfessDevelop getProfessDevelop() {
        return professDevelop;
    }

    public void setProfessDevelop(ProfessDevelop professDevelop) {
        this.professDevelop = professDevelop;
    }
}
