package com.telecom.jx.sjy.dangyuanback.mapper;

import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAward;

import java.util.List;
import java.util.Map;

public interface HonorsAwardMapper {
    List<HonorsAward> selectHonorsAwards(Integer year);

    HonorsAward selectHonorsAwardById(Long honorsAwardId);

    void updateHonorsAward(HonorsAward honorsAward);

    void insertHonorsAward(HonorsAward honorsAward);

    void insertHonorsAwardArrange(Map<String, Object> map);

    void insertHonorsAward3Arrange(Map<String, Object> map);
}
