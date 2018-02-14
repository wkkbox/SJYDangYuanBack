package com.telecom.jx.sjy.dangyuanback.service;



import com.telecom.jx.sjy.dangyuanback.pojo.po.ActivityContent;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;

import java.util.List;

public interface ActivityService {
    List<DangZe> getDangZes(Long userId, Long roleId) throws Exception;

    Long saveActivityContent(ActivityContent activityContent) throws Exception;
}
