package com.telecom.jx.sjy.dangyuanback.service.impl;

import com.telecom.jx.sjy.dangyuanback.mapper.AchievementMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.InfoMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.UserMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;
import com.telecom.jx.sjy.dangyuanback.pojo.po.AchievementContent;
import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.AchievementArrangeCustom;
import com.telecom.jx.sjy.dangyuanback.service.AchievementService;
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
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<Achievement> getAchievements() throws Exception {
        //查询所有工作业绩集合
        Integer year = DateUtil.getYear(new Date());
        return achievementMapper.selectAchievements(year);
    }

    @Override
    public Achievement getAchievementById(Long achievementId) throws Exception {
        return achievementMapper.selectAchievementById(achievementId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void editAchievement(Achievement achievement) throws Exception {
        achievementMapper.updateAchievement(achievement);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addAchievement(Achievement achievement) throws Exception {
        //在工作业绩表添加一条记录
        String year = String.valueOf(DateUtil.getYear(new Date()));
        achievement.setYear(year);
        achievement.setPublishTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        achievement.setRoleId((long) 3);
        achievement.setlScore(achievement.getdScore());
        achievement.sethScore(achievement.getdScore());
        achievementMapper.insertAchievement(achievement);
        Long achievementId = achievement.getId();
        System.out.println("achievementId=" + achievementId);
        //无限次数和不是无限次数
        if (achievement.getRate() == 0) {//不是无限次数的情况,0表示每月一次
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
                map.put("achievementId", achievementId);
                achievementMapper.insertAchievementArrange(map);
            }
        } else if (achievement.getRate() == 1) {//不是无限次数的情况,1表示每季度一次
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
                map.put("achievementId", achievementId);
                achievementMapper.insertAchievementArrange(map);
            }
        } else if (achievement.getRate() == 2) {//不是无限次数的情况,2表示每年一次
            for (int i = 1; i <= 12; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("month", year + i);
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("achievementId", achievementId);
                achievementMapper.insertAchievementArrange(map);
            }
        } else if (achievement.getRate() == 3) {//无限次数的情况
            List<User> users = userMapper.selectUsers();
            for (User item : users) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("userId", item.getId());
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("achievementId", achievementId);
                achievementMapper.insertAchievement3Arrange(map);
            }
        }
        //发布的工作业绩给所有用户添加消息
        //在t_info表添加一条记录,先判断
        /*Map<String, Object> map_ = new HashMap<>();
        map_.put("title", achievement.getTitle());
        map_.put("content", achievement.getContent());
        if (infoMapper.selectInfoByTitleAndContent(map_) == null) {
            Info info = new Info();
            info.setTitle(achievement.getTitle());
            info.setContent(achievement.getContent());
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
    public List<AchievementContent> getAchievementContents() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("year",String.valueOf(DateUtil.getYear(new Date())));
        List<AchievementContent> achievementContents=achievementMapper.selectAchievementContents(map);
        return achievementContents;
    }

    @Override
    public AchievementArrangeCustom getAchievementArrangeCustom(Long arrangeId) throws Exception {
        return achievementMapper.selectAchievementArrangeCustom(arrangeId);
    }

    @Override
    public AchievementArrangeCustom getAchievement3ArrangeCustom(Long arrangeId) throws Exception {
        return achievementMapper.selectAchievement3ArrangeCustom(arrangeId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void passAchievement(Map<String, Object> map) throws Exception {
        if ((int) map.get("otherAttr") == 1) {
            map.put("title","(考核优秀)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 2) {
            map.put("title","(考核称职)"+map.get("title"));
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
        achievementMapper.passAchievement(map);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void noPassAchievement(Long userAchievementId, Map<String, Object> map) throws Exception {
        if ((int) map.get("otherAttr") == 1) {
            map.put("title","(考核优秀)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 2) {
            map.put("title","(考核称职)"+map.get("title"));
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
        achievementMapper.noPassAchievement(userAchievementId);
    }
}
