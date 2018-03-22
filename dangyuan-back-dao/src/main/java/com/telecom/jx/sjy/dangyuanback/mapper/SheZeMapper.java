package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZeContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.SheZeArrangeCustom;

import java.util.List;
import java.util.Map;

public interface SheZeMapper {
    List<SheZe> selectSheZes(Integer year);

    Integer selectDangZeState(Map<String, Object> map);

    void insertSheZe3Arrange(Map<String, Object> map);

    void insertSheZe(SheZe sheZe);

    void insertSheZeArrange(Map<String, Object> map);

    SheZe selectSheZeById(Long shezeId);

    void updateSheZe(SheZe sheZe);

    List<SheZeContent> selectSheZeContents(Map<String, Object> map);

    SheZeArrangeCustom selectSheZeArrangeCustom(Long arrangeId);

    SheZeArrangeCustom selectSheZe3ArrangeCustom(Long arrangeId);

    void passSheZe(Map<String, Object> map);

    void noPassSheZe(Long userShezeId);

    Integer selectSheZeMonthScore(Map<String, Object> scoreMap);

    Integer selectSheZeSeasonScore(Map<String, Object> scoreMap);

    Integer selectSheZeYearScore(Map<String, Object> scoreMap);
}
