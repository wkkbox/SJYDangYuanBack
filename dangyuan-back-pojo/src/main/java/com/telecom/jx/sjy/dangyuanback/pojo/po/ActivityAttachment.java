package com.telecom.jx.sjy.dangyuanback.pojo.po;

import java.io.Serializable;

/**
 * 完成活动后上传的活动附件实体
 */
public class ActivityAttachment implements Serializable {

    private Long id;//主键
    private String localAddress;//本机地址
    private String serverAddress;//服务器地址
    private Integer attachmentType;//附件类型，0是照片
    private String uploadTime;//上传时间
    private Long contentId;//外键，活动附件所属活动记录id
    private Integer activityType;//附件所属活动类型，0是党责活动

    //private Long userId;//附件所属用户id
    //private Long activityId;//附件所属活动id


    @Override
    public String toString() {
        return "id=" + id + ",localAddress=" + localAddress + ",serverAddress=" + serverAddress + ",attachmentType=" + attachmentType + ",uploadTime=" + uploadTime + ",contentId=" + contentId;
    }

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

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(Integer attachmentType) {
        this.attachmentType = attachmentType;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }
}
