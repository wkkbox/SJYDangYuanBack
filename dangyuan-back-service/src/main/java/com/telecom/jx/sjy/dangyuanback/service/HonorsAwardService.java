package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAward;
import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAwardContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.HonorsAwardArrangeCustom;

import java.util.List;
import java.util.Map;

public interface HonorsAwardService {
    List<HonorsAward> getHonorsAwards() throws Exception;

    HonorsAward getHonorsAwardById(Long honorsAwardId) throws Exception;

    void editHonorsAward(HonorsAward honorsAward) throws Exception;

    void addHonorsAward(HonorsAward honorsAward) throws Exception;

    List<HonorsAwardContent> getHonorsAwardContents() throws Exception;

    HonorsAwardArrangeCustom getHonorsAwardArrangeCustom(Long arrangeId) throws Exception;

    HonorsAwardArrangeCustom getHonorsAward3ArrangeCustom(Long arrangeId) throws Exception;

    void passHonorsAward(Map<String, Object> map) throws Exception;

    void noPassHonorsAward(Long userHonorsAwardId) throws Exception;
}
