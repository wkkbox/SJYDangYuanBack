package com.telecom.jx.sjy.dangyuanback.pojo.vo;

import java.io.Serializable;

public class AchievementArrangeCustom implements Serializable {

    private String time;
    private Long achievementId;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }
}
