package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZeContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.SheZeArrangeCustom;

import java.util.List;
import java.util.Map;

public interface SheZeService {
    void addSheZe(SheZe sheZe) throws Exception;

    List<SheZe> getSheZes() throws Exception;

    SheZe getSheZeById(Long shezeId) throws Exception;

    void editSheZe(SheZe sheZe) throws Exception;

    List<SheZeContent> getSheZeContents() throws Exception;

    SheZeArrangeCustom getSheZeArrangeCustom(Long arrangeId) throws Exception;

    SheZeArrangeCustom getSheZe3ArrangeCustom(Long arrangeId) throws Exception;

    void passSheZe(Map<String, Object> map) throws Exception;

    void noPassSheZe(Long userShezeId, Map<String, Object> map) throws Exception;
}
