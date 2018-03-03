package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;

import java.util.List;
import java.util.Map;

public interface DangZeMapper {
    List<DangZe> selectDangZes(Integer year);

    Integer selectDangZeState(Map<String, Object> map);

    void insertDangZe3Arrange(Map<String, Object> map);

    void insertDangZe(DangZe dangZe);

    void insertDangZeArrange(Map<String, Object> map);
}
