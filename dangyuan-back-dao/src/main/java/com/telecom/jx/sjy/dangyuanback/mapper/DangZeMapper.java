package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;

import java.util.List;
import java.util.Map;

public interface DangZeMapper {
    List<DangZe> selectDangZes(Long roleId) throws Exception;

    Integer selectDangZeState(Map<String, Object> map) throws Exception;
}
