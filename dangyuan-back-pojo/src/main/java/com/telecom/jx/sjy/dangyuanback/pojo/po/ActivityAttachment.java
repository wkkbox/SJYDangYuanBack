package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;

/**
 * 完成活动后上传的活动附件
 */
public class ActivityAttachment implements Serializable {

    private Long id;//主键
    private String localAddress;//本机地址
    private String serverAddress;//服务器地址
    private Integer attachmentType;//附件类型，0是照片
    private String uploadtime;//上传时间
    private Long userId;//附件所属用户id
    private Long activityContentId;//外键，活动附件所属活动记录id
    private Long activityId;//附件所属活动id
    private Integer activityType;//附件所属活动类型，0是党责活动


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(String uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(Integer attachmentType) {
        this.attachmentType = attachmentType;
    }

    public Long getActivityContentId() {
        return activityContentId;
    }

    public void setActivityContentId(Long activityContentId) {
        this.activityContentId = activityContentId;
    }
}
