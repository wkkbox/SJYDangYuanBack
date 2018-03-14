package com.telecom.jx.sjy.dangyuanback.mapper;

import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAward;
import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAwardContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.HonorsAwardArrangeCustom;

import java.util.List;
import java.util.Map;

public interface HonorsAwardMapper {
    List<HonorsAward> selectHonorsAwards(Integer year);

    HonorsAward selectHonorsAwardById(Long honorsAwardId);

    void updateHonorsAward(HonorsAward honorsAward);

    void insertHonorsAward(HonorsAward honorsAward);

    void insertHonorsAwardArrange(Map<String, Object> map);

    void insertHonorsAward3Arrange(Map<String, Object> map);

    List<HonorsAwardContent> selectHonorsAwardContents(Map<String, Object> map);

    HonorsAwardArrangeCustom selectHonorsAwardArrangeCustom(Long arrangeId);

    HonorsAwardArrangeCustom selectHonorsAward3ArrangeCustom(Long arrangeId);

    void passHonorsAward(Map<String, Object> map);

    void noPassHonorsAward(Long userHonorsAwardId);
}
