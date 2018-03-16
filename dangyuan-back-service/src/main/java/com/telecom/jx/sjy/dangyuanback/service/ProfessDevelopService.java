package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelop;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelopContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.ProfessDevelopArrangeCustom;

import java.util.List;
import java.util.Map;

public interface ProfessDevelopService {
    List<ProfessDevelop> getProfessDevelops() throws Exception;

    ProfessDevelop getProfessDevelopById(Long professDevelopId) throws Exception;

    void editProfessDevelop(ProfessDevelop professDevelop) throws Exception;

    void addProfessDevelop(ProfessDevelop professDevelop) throws Exception;

    List<ProfessDevelopContent> getProfessDevelopContents() throws Exception;

    ProfessDevelopArrangeCustom getProfessDevelopArrangeCustom(Long arrangeId) throws Exception;

    ProfessDevelopArrangeCustom getProfessDevelop3ArrangeCustom(Long arrangeId) throws Exception;

    void passProfessDevelop(Map<String, Object> map) throws Exception;

    void noPassProfessDevelop(Long userProfessDevelopId, Map<String, Object> map) throws Exception;
}
