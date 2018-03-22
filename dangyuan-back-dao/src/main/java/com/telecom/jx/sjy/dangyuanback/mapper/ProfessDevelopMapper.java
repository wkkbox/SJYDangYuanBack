package com.telecom.jx.sjy.dangyuanback.mapper;

import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelop;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelopContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.ProfessDevelopArrangeCustom;

import java.util.List;
import java.util.Map;

public interface ProfessDevelopMapper {
    List<ProfessDevelop> selectProfessDevelops(Integer year);

    ProfessDevelop selectProfessDevelopById(Long professDevelopId);

    void updateProfessDevelop(ProfessDevelop professDevelop);

    void insertProfessDevelop(ProfessDevelop professDevelop);

    void insertProfessDevelopArrange(Map<String, Object> map);

    void insertProfessDevelop3Arrange(Map<String, Object> map);

    List<ProfessDevelopContent> selectProfessDevelopContents(Map<String, Object> map);

    ProfessDevelopArrangeCustom selectProfessDevelopArrangeCustom(Long arrangeId);

    ProfessDevelopArrangeCustom selectProfessDevelop3ArrangeCustom(Long arrangeId);

    void passProfessDevelop(Map<String, Object> map);

    void noPassProfessDevelop(Long userProfessDevelopId);

    Integer selectProfessDevelopMonthScore(Map<String, Object> scoreMap);

    Integer selectProfessDevelopSeasonScore(Map<String, Object> scoreMap);

    Integer selectProfessDevelopYearScore(Map<String, Object> scoreMap);
}
