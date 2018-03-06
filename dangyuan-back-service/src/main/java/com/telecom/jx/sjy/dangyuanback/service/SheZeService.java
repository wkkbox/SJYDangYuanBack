package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;

import java.util.List;

public interface SheZeService {
    void addSheZe(SheZe sheZe) throws Exception;

    List<SheZe> getSheZes() throws Exception;

    SheZe getSheZeById(Long shezeId) throws Exception;

    void editSheZe(SheZe sheZe) throws Exception;
}
