package com.telecom.jx.sjy.dangyuanback.pojo.vo;

import java.io.Serializable;

public class SheZeArrangeCustom implements Serializable {

    private String time;
    private Long shezeId;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Long getShezeId() {
        return shezeId;
    }

    public void setShezeId(Long shezeId) {
        this.shezeId = shezeId;
    }
}
