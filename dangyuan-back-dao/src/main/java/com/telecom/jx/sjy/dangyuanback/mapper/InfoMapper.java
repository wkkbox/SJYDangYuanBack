package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;

import java.util.List;
import java.util.Map;

public interface InfoMapper {
    Integer selectUnreadInfoCount(Long userId) throws Exception;

    Integer selectInfoSize(Long roleId) throws Exception;

    List<Info> selectInfoByPage(Map<String, Object> map) throws Exception;

    List<Long> selectUnreadInfoId(Long userId) throws Exception;

    Info selectInfoByInfoId(Long infoId) throws Exception;

    void updateInfoReaded(Long infoId) throws Exception;
}
