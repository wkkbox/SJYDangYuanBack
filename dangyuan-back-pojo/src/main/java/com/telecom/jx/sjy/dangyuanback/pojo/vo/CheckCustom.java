package com.telecom.jx.sjy.dangyuanback.pojo.vo;

import com.telecom.jx.sjy.dangyuanback.pojo.po.ActivityAttachment;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;

import java.io.Serializable;
import java.util.List;

public class CheckCustom implements Serializable {

    private Long userDangzeId;
    private List<ActivityAttachment> attachments;
    private DangZe dangZe;
    private User user;
    private String commitTime;
    private String content;

    public CheckCustom(Long userDangzeId,List<ActivityAttachment> attachments,DangZe dangZe,User user,String commitTime,String content){
        this.user = user;
        this.commitTime = commitTime;
        this.dangZe = dangZe;
        this.userDangzeId = userDangzeId;
        this.attachments = attachments;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
