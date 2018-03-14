package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZeContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.DangZeArrangeCustom;

import java.util.List;
import java.util.Map;

public interface DangZeService {
    void addDangZe(DangZe dangZe) throws Exception;

    List<DangZe> getDangZes() throws Exception;

    DangZe getDangZeById(Long dangzeId) throws Exception;

    void editDangZe(DangZe dangZe) throws Exception;

    List<DangZeContent> getDangZeContents() throws Exception;

    DangZeArrangeCustom getDangZeArrangeCustom(Long arrangeId) throws Exception;

    DangZeArrangeCustom getDangZe3ArrangeCustom(Long arrangeId) throws Exception;

    Long getUserDangZeId(Map<String, Object> map) throws Exception;

    String getCommitTime(Long userDangzeId) throws Exception;

    Integer getUserDangZeState(Map<String, Object> map) throws Exception;

    void passDangZe(Map<String, Object> map) throws Exception;

    void noPassDangZe(Long userDangzeId) throws Exception;
}
