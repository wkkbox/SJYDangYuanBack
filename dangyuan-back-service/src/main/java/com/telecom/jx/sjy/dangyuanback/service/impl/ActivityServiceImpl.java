package com.telecom.jx.sjy.dangyuanback.service.impl;


import com.telecom.jx.sjy.dangyuanback.mapper.ActivityContentMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.DangZeMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ActivityContent;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private DangZeMapper dangZeMapper;

    @Autowired
    private ActivityContentMapper activityContentMapper;

    @Override
    public List<DangZe> getDangZes(Long userId, Long roleId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        List<DangZe> dangZeList = dangZeMapper.selectDangZes(roleId);
        for (DangZe item : dangZeList) {
            map.put("dangzeId", item.getId());
            Integer state = dangZeMapper.selectDangZeState(map);
            item.setState(state);
        }
        return dangZeList;
    }

    @Override
    public Long saveActivityContent(ActivityContent activityContent) throws Exception {
        activityContentMapper.insertActivityContent(activityContent);
        return activityContent.getId();
    }
}
