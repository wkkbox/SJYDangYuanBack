package com.telecom.jx.sjy.dangyuanback.mapper;

import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelop;

import java.util.List;
import java.util.Map;

public interface ProfessDevelopMapper {
    List<ProfessDevelop> selectProfessDevelops(Integer year);

    ProfessDevelop selectProfessDevelopById(Long professDevelopId);

    void updateProfessDevelop(ProfessDevelop professDevelop);

    void insertProfessDevelop(ProfessDevelop professDevelop);

    void insertProfessDevelopArrange(Map<String, Object> map);

    void insertProfessDevelop3Arrange(Map<String, Object> map);
}
