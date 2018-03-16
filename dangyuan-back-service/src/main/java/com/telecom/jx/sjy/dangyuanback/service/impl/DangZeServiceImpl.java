package com.telecom.jx.sjy.dangyuanback.service.impl;

import com.telecom.jx.sjy.dangyuanback.mapper.DangZeMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.InfoMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.UserMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.*;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.DangZeArrangeCustom;
import com.telecom.jx.sjy.dangyuanback.service.DangZeService;
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
public class DangZeServiceImpl implements DangZeService {

    @Autowired
    private DangZeMapper dangZeMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addDangZe(DangZe dangZe) throws Exception {
        //在党责表添加一条记录
        String year = String.valueOf(DateUtil.getYear(new Date()));
        dangZe.setYear(year);
        dangZe.setPublishTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        dangZe.setRoleId((long) 3);
        dangZe.setlScore(dangZe.getdScore());
        dangZe.sethScore(dangZe.getdScore());
        dangZeMapper.insertDangZe(dangZe);
        Long dangzeId = dangZe.getId();
        System.out.println("dangzeId=" + dangzeId);
        //无限次数和不是无限次数
        if (dangZe.getRate() == 0) {//不是无限次数的情况,0表示每月一次
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
                map.put("dangzeId", dangzeId);
                dangZeMapper.insertDangZeArrange(map);
            }
        } else if (dangZe.getRate() == 1) {//不是无限次数的情况,1表示每季度一次
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
                map.put("dangzeId", dangzeId);
                dangZeMapper.insertDangZeArrange(map);
            }
        } else if (dangZe.getRate() == 2) {//不是无限次数的情况,2表示每年一次
            for (int i = 1; i <= 12; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("month", year + i);
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("dangzeId", dangzeId);
                dangZeMapper.insertDangZeArrange(map);
            }
        } else if (dangZe.getRate() == 3) {//无限次数的情况
            List<User> users = userMapper.selectUsers();
            for (User item : users) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("userId", item.getId());
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("dangzeId", dangzeId);
                dangZeMapper.insertDangZe3Arrange(map);
            }
        }
        //发布的党责活动给所有用户添加消息
        //在t_info表添加一条记录,先判断
        Map<String, Object> map_ = new HashMap<>();
        map_.put("title", dangZe.getTitle());
        map_.put("content", dangZe.getContent());
        if (infoMapper.selectInfoByTitleAndContent(map_) == null) {
            Info info = new Info();
            info.setTitle(dangZe.getTitle());
            info.setContent(dangZe.getContent());
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
    }

    @Override
    public List<DangZe> getDangZes() throws Exception {
        //查询所有党责集合
        Integer year = DateUtil.getYear(new Date());
        return dangZeMapper.selectDangZes(year);
    }

    @Override
    public DangZe getDangZeById(Long dangzeId) throws Exception {
        return dangZeMapper.selectDangZeById(dangzeId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void editDangZe(DangZe dangZe) throws Exception {
        //更新info之后写
        dangZeMapper.updateDangZe(dangZe);
    }

    @Override
    public List<DangZeContent> getDangZeContents() throws Exception {
        Map<String, Object> map = new HashMap<>();
        //System.out.println("year="+String.valueOf(DateUtil.getYear(new Date())));
        map.put("year", String.valueOf(DateUtil.getYear(new Date())));
        List<DangZeContent> dangZeContents = dangZeMapper.selectDangZeContents(map);
        //System.out.println("size="+dangZeContents.size());

        return dangZeContents;
    }

    @Override
    public DangZeArrangeCustom getDangZeArrangeCustom(Long arrangeId) throws Exception {
        return dangZeMapper.selectDangZeArrangeCustom(arrangeId);
    }

    @Override
    public DangZeArrangeCustom getDangZe3ArrangeCustom(Long arrangeId) throws Exception {
        return dangZeMapper.selectDangZe3ArrangeCustom(arrangeId);
    }

    @Override
    public Long getUserDangZeId(Map<String, Object> map) throws Exception {
        return dangZeMapper.selectUserDangZeId(map);
    }

    @Override
    public String getCommitTime(Long userDangzeId) throws Exception {
        return dangZeMapper.selectCommitTime(userDangzeId);
    }

    @Override
    public Integer getUserDangZeState(Map<String, Object> map) throws Exception {
        return dangZeMapper.selectUserDangZeState(map);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void passDangZe(Map<String, Object> map) throws Exception {
        map.put("content","你申请的"+map.get("title")+"于"+map.get("publishtime")+"审核通过，获得"+map.get("rScore")+"分");
        Long id = IDUtils.getItemId();
        map.put("id",id);
        //插入用户信息表
        infoMapper.insertInfoUser(map);
        //插入未读表
        map.put("infoId",id);
        infoMapper.insertUnReadedInfo(map);
        //修改进度表
        dangZeMapper.passDangZe(map);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void noPassDangZe(Long userDangzeId, Map<String, Object> map) throws Exception {
        map.put("content","你申请的"+map.get("title")+"于"+map.get("publishtime")+"审核不通过，请重新申请");
        Long id = IDUtils.getItemId();
        map.put("id",id);
        //插入用户信息表
        infoMapper.insertInfoUser(map);
        //插入未读表
        map.put("infoId",id);
        infoMapper.insertUnReadedInfo(map);
        //修改进度表
        dangZeMapper.noPassDangZe(userDangzeId);
    }
}
