package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelop;

import java.util.List;

public interface ProfessDevelopService {
    List<ProfessDevelop> getProfessDevelops() throws Exception;

    ProfessDevelop getProfessDevelopById(Long professDevelopId) throws Exception;

    void editProfessDevelop(ProfessDevelop professDevelop) throws Exception;

    void addProfessDevelop(ProfessDevelop professDevelop) throws Exception;
}
