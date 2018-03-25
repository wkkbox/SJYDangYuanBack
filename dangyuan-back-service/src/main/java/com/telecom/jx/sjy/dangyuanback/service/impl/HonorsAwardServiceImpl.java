package com.telecom.jx.sjy.dangyuanback.service.impl;

import com.telecom.jx.sjy.dangyuanback.mapper.HonorsAwardMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.InfoMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.UserMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAward;
import com.telecom.jx.sjy.dangyuanback.pojo.po.HonorsAwardContent;
import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.HonorsAwardArrangeCustom;
import com.telecom.jx.sjy.dangyuanback.service.HonorsAwardService;
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
public class HonorsAwardServiceImpl implements HonorsAwardService {

    @Autowired
    private HonorsAwardMapper honorsAwardMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<HonorsAward> getHonorsAwards() throws Exception {
        //查询所有荣誉奖励
        Integer year = DateUtil.getYear(new Date());
        return honorsAwardMapper.selectHonorsAwards(year);
    }

    @Override
    public HonorsAward getHonorsAwardById(Long honorsAwardId) throws Exception {
        return honorsAwardMapper.selectHonorsAwardById(honorsAwardId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void editHonorsAward(HonorsAward honorsAward) throws Exception {
        honorsAwardMapper.updateHonorsAward(honorsAward);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addHonorsAward(HonorsAward honorsAward) throws Exception {
        //在荣誉奖励表添加一条记录
        String year = String.valueOf(DateUtil.getYear(new Date()));
        honorsAward.setYear(year);
        honorsAward.setPublishTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        honorsAward.setRoleId((long) 3);
        if (honorsAward.getlScore() == honorsAward.gethScore()) {
            honorsAward.setdScore(honorsAward.getlScore());
        } else {
            honorsAward.setdScore(-1);
        }
        honorsAwardMapper.insertHonorsAward(honorsAward);
        Long honorsAwardId = honorsAward.getId();
        System.out.println("honorsAwardId=" + honorsAwardId);
        //无限次数和不是无限次数
        if (honorsAward.getRate() == 0) {//不是无限次数的情况,0表示每月一次
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
                map.put("honorsAwardId", honorsAwardId);
                honorsAwardMapper.insertHonorsAwardArrange(map);
            }
        } else if (honorsAward.getRate() == 1) {//不是无限次数的情况,1表示每季度一次
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
                map.put("honorsAwardId", honorsAwardId);
                honorsAwardMapper.insertHonorsAwardArrange(map);
            }
        } else if (honorsAward.getRate() == 2) {//不是无限次数的情况,2表示每年一次
            for (int i = 1; i <= 12; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("month", year + i);
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("honorsAwardId", honorsAwardId);
                honorsAwardMapper.insertHonorsAwardArrange(map);
            }
        } else if (honorsAward.getRate() == 3) {//无限次数的情况
            List<User> users = userMapper.selectUsers();
            for (User item : users) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("userId", item.getId());
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("honorsAwardId", honorsAwardId);
                honorsAwardMapper.insertHonorsAward3Arrange(map);
            }
        }
        //发布的荣誉奖励活动给所有用户添加消息
        //在t_info表添加一条记录,先判断
        /*Map<String, Object> map_ = new HashMap<>();
        map_.put("title", honorsAward.getTitle());
        map_.put("content", honorsAward.getContent());
        if (infoMapper.selectInfoByTitleAndContent(map_) == null) {
            Info info = new Info();
            //Integer otherAttr = honorsAwardMapper.selectHonorsAwardById(honorsAwardId).getOtherAttr();
            info.setTitle(honorsAward.getTitle());
            info.setContent(honorsAward.getContent());
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
        }*/
    }

    @Override
    public List<HonorsAwardContent> getHonorsAwardContents() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("year",String.valueOf(DateUtil.getYear(new Date())));
        List<HonorsAwardContent> honorsAwardContents=honorsAwardMapper.selectHonorsAwardContents(map);
        return honorsAwardContents;
    }

    @Override
    public HonorsAwardArrangeCustom getHonorsAwardArrangeCustom(Long arrangeId) throws Exception {
        return honorsAwardMapper.selectHonorsAwardArrangeCustom(arrangeId);
    }

    @Override
    public HonorsAwardArrangeCustom getHonorsAward3ArrangeCustom(Long arrangeId) throws Exception {
        return honorsAwardMapper.selectHonorsAward3ArrangeCustom(arrangeId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void passHonorsAward(Map<String, Object> map) throws Exception {
        if ((int) map.get("otherAttr") == 1) {
            map.put("title","(国家级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 2) {
            map.put("title","(省部级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 3) {
            map.put("title","(地市级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 4) {
            map.put("title","(县(区)级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 5) {
            map.put("title","(集团(中央企业)级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 6) {
            map.put("title","(行业级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 7) {
            map.put("title","(省公司级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 8) {
            map.put("title","(市公司级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 9) {
            map.put("title","(客户级)"+map.get("title"));
        }
        map.put("content", "你申请的" + map.get("title") + "于" + map.get("publishtime") + "审核通过，获得" + map.get("rScore") + "分");
        Long id = IDUtils.getItemId();
        map.put("id",id);
        //插入用户信息表
        infoMapper.insertInfoUser(map);
        //插入未读表
        map.put("infoId",id);
        infoMapper.insertUnReadedInfo(map);
        //修改进度表
        honorsAwardMapper.passHonorsAward(map);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void noPassHonorsAward(Long userHonorsAwardId, Map<String, Object> map) throws Exception {
        if ((int) map.get("otherAttr") == 1) {
            map.put("title","(国家级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 2) {
            map.put("title","(省部级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 3) {
            map.put("title","(地市级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 4) {
            map.put("title","(县(区)级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 5) {
            map.put("title","(集团(中央企业)级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 6) {
            map.put("title","(行业级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 7) {
            map.put("title","(省公司级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 8) {
            map.put("title","(市公司级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 9) {
            map.put("title","(客户级)"+map.get("title"));
        }
        map.put("content","你申请的"+map.get("title")+"于"+map.get("publishtime")+"审核不通过，请重新申请");
        Long id = IDUtils.getItemId();
        map.put("id",id);
        //插入用户信息表
        infoMapper.insertInfoUser(map);
        //插入未读表
        map.put("infoId",id);
        infoMapper.insertUnReadedInfo(map);
        //修改进度表
        honorsAwardMapper.noPassHonorsAward(userHonorsAwardId);
    }

}
