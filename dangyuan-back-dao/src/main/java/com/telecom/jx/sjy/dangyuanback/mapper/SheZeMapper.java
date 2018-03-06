package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;

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
}
