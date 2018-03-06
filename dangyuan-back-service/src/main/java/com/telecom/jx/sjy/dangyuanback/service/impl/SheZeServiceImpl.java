package com.telecom.jx.sjy.dangyuanback.service.impl;

import com.telecom.jx.sjy.dangyuanback.mapper.InfoMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.SheZeMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.UserMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;
import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.service.SheZeService;
import com.telecom.jx.sjy.dangyuanback.util.DateUtil;
import com.telecom.jx.sjy.dangyuanback.util.IDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SheZeServiceImpl implements SheZeService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private SheZeMapper sheZeMapper;


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addSheZe(SheZe sheZe) throws Exception {
        //在社责表添加一条记录
        String year = String.valueOf(DateUtil.getYear(new Date()));
        sheZe.setYear(year);
        sheZe.setPublishTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        sheZe.setRoleId((long) 3);
        if (sheZe.getlScore() == sheZe.gethScore()) {
            sheZe.setdScore(sheZe.getlScore());
        } else {
            sheZe.setdScore(-1);
        }
        sheZeMapper.insertSheZe(sheZe);
        Long shezeId = sheZe.getId();
        System.out.println("shezeId=" + shezeId);
        //无限次数和不是无限次数
        if (sheZe.getRate() == 0) {//不是无限次数的情况,0表示每月一次
            for (int i = 1; i <= 12; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("month", year + i);
                if (i < 10) {
                    map.put("time", year + "-0" + i + "-01 00:00:00");
                } else {
                    map.put("time", year + "-" + i + "-01 00:00:00");
                }
                map.put("shezeId", shezeId);
                sheZeMapper.insertSheZeArrange(map);
            }
        } else if (sheZe.getRate() == 1) {//不是无限次数的情况,1表示每季度一次
            for (int i = 1; i <= 12; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("month", year + i);
                if (i >= 1 && i <= 3) {
                    map.put("time", year + "-01" + "-01 00:00:00");
                } else if (i >= 4 && i <= 6) {
                    map.put("time", year + "-04" + "-01 00:00:00");
                } else if (i >= 7 && i <= 9) {
                    map.put("time", year + "-07" + "-01 00:00:00");
                } else if (i >= 10 && i <= 12) {
                    map.put("time", year + "-10" + "-01 00:00:00");
                }
                map.put("shezeId", shezeId);
                sheZeMapper.insertSheZeArrange(map);
            }
        } else if (sheZe.getRate() == 2) {//不是无限次数的情况,2表示每年一次
            for (int i = 1; i <= 12; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("month", year + i);
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("shezeId", shezeId);
                sheZeMapper.insertSheZeArrange(map);
            }
        } else if (sheZe.getRate() == 3) {//无限次数的情况
            List<User> users = userMapper.selectUsers();
            for (User item : users) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("userId", item.getId());
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("shezeId", shezeId);
                sheZeMapper.insertSheZe3Arrange(map);
            }
        }
        //发布的社责活动给所有用户添加消息
        //在t_info表添加一条记录
        Info info = new Info();
        Integer otherAttr = sheZeMapper.selectSheZeById(shezeId).getOtherAttr();
        if (otherAttr == 1) {
            info.setTitle(sheZe.getTitle() + "(个人名义参加)");
            info.setContent(sheZe.getContent() + "(个人名义参加)");
        }
        if (otherAttr == 2) {
            info.setTitle(sheZe.getTitle() + "(集体名义参加)");
            info.setContent(sheZe.getContent() + "(集体名义参加)");
        }
        if (otherAttr == 0) {
            info.setTitle(sheZe.getTitle());
            info.setContent(sheZe.getContent());
        }
        info.setYear(year);
        info.setPublishtime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        info.setRoleId((long) 3);
        infoMapper.insertInfo(info);
        Long infoId = info.getId();
        //在消息未读表为每个用户添加一条记录
        List<User> users = userMapper.selectUsers();
        for (User item : users) {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", item.getId());
            map.put("infoId", infoId);
            map.put("year", year);
            infoMapper.insertUnReadedInfo(map);
        }

    }

    @Override
    public List<SheZe> getSheZes() throws Exception {
        //查询所有社责集合
        Integer year = DateUtil.getYear(new Date());
        return sheZeMapper.selectSheZes(year);
    }

    @Override
    public SheZe getSheZeById(Long shezeId) throws Exception {
        return sheZeMapper.selectSheZeById(shezeId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void editSheZe(SheZe sheZe) throws Exception {
        sheZeMapper.updateSheZe(sheZe);
    }
}