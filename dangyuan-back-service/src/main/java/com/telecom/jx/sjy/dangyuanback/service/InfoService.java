package com.telecom.jx.sjy.dangyuanback.service;


import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;
import com.telecom.jx.sjy.dangyuanback.util.dto.PageBean;

public interface InfoService {
    Integer getUnreadInfoCount(Long userId) throws Exception;

    PageBean<Info> getInfos(Long userId, Long roleId, Integer currentPage, Integer pageSize) throws Exception;

    Info getInfoByInfoId(Long infoId) throws Exception;
}
