package com.telecom.jx.sjy.dangyuanback.pojo.vo;

import java.io.Serializable;

public class HonorsAwardArrangeCustom implements Serializable {

    private String time;
    private Long honorsAwardId;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Long getHonorsAwardId() {
        return honorsAwardId;
    }

    public void setHonorsAwardId(Long honorsAwardId) {
        this.honorsAwardId = honorsAwardId;
    }
}
