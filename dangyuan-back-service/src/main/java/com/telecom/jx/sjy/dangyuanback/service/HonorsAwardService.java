package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAward;

import java.util.List;

public interface HonorsAwardService {
    List<HonorsAward> getHonorsAwards() throws Exception;

    HonorsAward getHonorsAwardById(Long honorsAwardId) throws Exception;

    void editHonorsAward(HonorsAward honorsAward) throws Exception;

    void addHonorsAward(HonorsAward honorsAward) throws Exception;
}
