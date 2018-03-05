package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;

import java.util.List;

public interface DangZeService {
    void addDangZe(DangZe dangZe) throws Exception;

    List<DangZe> getDangZes() throws Exception;

    DangZe getDangZeById(Long dangzeId) throws Exception;

    void editDangZe(DangZe dangZe) throws Exception;
}
