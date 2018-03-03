package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;

import java.util.List;
import java.util.Map;

public interface InfoMapper {
    List<Info> selectInfos(Integer year);

    void insertUnReadedInfo(Map<String, Object> map);

    void insertInfo(Info info);
}
