package com.telecom.jx.sjy.dangyuanback.service.impl;


import com.telecom.jx.sjy.dangyuanback.mapper.*;
import com.telecom.jx.sjy.dangyuanback.pojo.po.*;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.Score;
import com.telecom.jx.sjy.dangyuanback.service.UserService;
import com.telecom.jx.sjy.dangyuanback.util.CryptographyUtil;
import com.telecom.jx.sjy.dangyuanback.util.DateUtil;
import com.telecom.jx.sjy.dangyuanback.util.IDUtils;
import com.telecom.jx.sjy.dangyuanback.util.dto.Menu;
import com.telecom.jx.sjy.dangyuanback.util.dto.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private DangZeMapper dangZeMapper;

    @Autowired
    private SheZeMapper sheZeMapper;

    @Autowired
    private AchievementMapper achievementMapper;

    @Autowired
    private HonorsAwardMapper honorsAwardMapper;

    @Autowired
    private ProfessDevelopMapper professDevelopMapper;

    @Override
    public List<User> showUsers() throws Exception {
        return userMapper.listUsers();
    }

    @Override
    public List<User> getUserByUserName(String userName) throws Exception {
        return userMapper.selectUserByUserName(userName);
    }

    @Override
    public Set<String> getUserRolesByUserId(Long userId) throws Exception {
        return userMapper.selectUserRolesByUserId(userId);
    }

    @Override
    public List<String> getUserPermissionsByUserId(Long userId) throws Exception {
        return userMapper.selectUserPermissionsByUserId(userId);
    }

    @Override
    public List<Menu> getMenusByUserId(Long userId) throws Exception {
        return userMapper.selectMenusByUserId(userId);
    }

    @Override
    public User getUserByAccountName(String accountName) throws Exception {
        return userMapper.selectUserByAccountName(accountName);
    }

    @Override
    public List<Score> getMonthScorePublicity() throws Exception {
        List<Score> scoreList = userMapper.selectScorePublicity();
        //把参加的活动的分数设置上来
        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);
            Long userId = score.getId();
            Map<String, Object> scoreMap = new HashMap<>();
            scoreMap.put("year", DateUtil.getYear(new Date()));
            scoreMap.put("userId", userId);
            //党责分
            Integer dangZeScore = dangZeMapper.selectDangZeMonthScore(scoreMap);
            if (dangZeScore == null) {
                dangZeScore = 0;
            }
            //社责分
            Integer sheZeScore = sheZeMapper.selectSheZeMonthScore(scoreMap);
            if (sheZeScore == null) {
                sheZeScore = 0;
            }
            //工作业绩分
            Integer achieveScore = achievementMapper.selectAchieveMonthScore(scoreMap);
            if (achieveScore == null) {
                achieveScore = 0;
            }
            //荣誉奖励分
            Integer honorsAwardScore = honorsAwardMapper.selectHonorsAwardMonthScore(scoreMap);
            if (honorsAwardScore == null) {
                honorsAwardScore = 0;
            }
            //专业提升分
            Integer professDevelopScore = professDevelopMapper.selectProfessDevelopMonthScore(scoreMap);
            if (professDevelopScore == null) {
                professDevelopScore = 0;
            }
            Integer sumScore = dangZeScore + sheZeScore + achieveScore + honorsAwardScore + professDevelopScore;
            score.setScore(sumScore);
        }
        //积分降序排序
        Collections.sort(scoreList, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if (o1.getScore() < o2.getScore()) {
                    return 1;
                } else if (o1.getScore() == o2.getScore()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return scoreList;
    }

    @Override
    public List<Score> getSeasonScorePublicity() throws Exception {
        List<Score> scoreList = userMapper.selectScorePublicity();
        //把参加的活动的分数设置上来
        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);
            Long userId = score.getId();
            Map<String, Object> scoreMap = new HashMap<>();
            scoreMap.put("year", DateUtil.getYear(new Date()));
            scoreMap.put("userId", userId);
            //党责分
            Integer dangZeScore = dangZeMapper.selectDangZeSeasonScore(scoreMap);
            if (dangZeScore == null) {
                dangZeScore = 0;
            }
            //社责分
            Integer sheZeScore = sheZeMapper.selectSheZeSeasonScore(scoreMap);
            if (sheZeScore == null) {
                sheZeScore = 0;
            }
            //工作业绩分
            Integer achieveScore = achievementMapper.selectAchieveSeasonScore(scoreMap);
            if (achieveScore == null) {
                achieveScore = 0;
            }
            //荣誉奖励分
            Integer honorsAwardScore = honorsAwardMapper.selectHonorsAwardSeasonScore(scoreMap);
            if (honorsAwardScore == null) {
                honorsAwardScore = 0;
            }
            //专业提升分
            Integer professDevelopScore = professDevelopMapper.selectProfessDevelopSeasonScore(scoreMap);
            if (professDevelopScore == null) {
                professDevelopScore = 0;
            }
            Integer sumScore = dangZeScore + sheZeScore + achieveScore + honorsAwardScore + professDevelopScore;
            score.setScore(sumScore);
        }
        //积分降序排序
        Collections.sort(scoreList, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if (o1.getScore() < o2.getScore()) {
                    return 1;
                } else if (o1.getScore() == o2.getScore()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return scoreList;
    }

    @Override
    public List<Score> getYearScorePublicity() throws Exception {
        List<Score> scoreList = userMapper.selectScorePublicity();
        //把参加的活动的分数设置上来
        for (int i = 0; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);
            Long userId = score.getId();
            Map<String, Object> scoreMap = new HashMap<>();
            scoreMap.put("year", DateUtil.getYear(new Date()));
            scoreMap.put("userId", userId);
            //党责分
            Integer dangZeScore = dangZeMapper.selectDangZeYearScore(scoreMap);
            if (dangZeScore == null) {
                dangZeScore = 0;
            }
            //社责分
            Integer sheZeScore = sheZeMapper.selectSheZeYearScore(scoreMap);
            if (sheZeScore == null) {
                sheZeScore = 0;
            }
            //工作业绩分
            Integer achieveScore = achievementMapper.selectAchieveYearScore(scoreMap);
            if (achieveScore == null) {
                achieveScore = 0;
            }
            //荣誉奖励分
            Integer honorsAwardScore = honorsAwardMapper.selectHonorsAwardYearScore(scoreMap);
            if (honorsAwardScore == null) {
                honorsAwardScore = 0;
            }
            //专业提升分
            Integer professDevelopScore = professDevelopMapper.selectProfessDevelopYearScore(scoreMap);
            if (professDevelopScore == null) {
                professDevelopScore = 0;
            }
            Integer sumScore = dangZeScore + sheZeScore + achieveScore + honorsAwardScore + professDevelopScore;
            score.setScore(sumScore);
        }
        //积分降序排序
        Collections.sort(scoreList, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                if (o1.getScore() < o2.getScore()) {
                    return 1;
                } else if (o1.getScore() == o2.getScore()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        return scoreList;
    }

    @Override
    public PageBean<Score> getScorePublicityByPage(Integer currentPage, Integer pageSize) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Integer count = userMapper.selectScorePublicitySize();
        PageBean<Score> pBean = new PageBean<>();
        pBean.setCurrentPage(currentPage);
        pBean.setPageSize(pageSize);
        map.put("currentPage", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        pBean.setpList(userMapper.selectScorePublicityByPage(map));
        pBean.setTotalCount(count);
        pBean.setTotalPage((count + pageSize - 1) / pageSize);
        return pBean;
    }

    @Override
    public Long getUserHighRoleByUserId(Long userId) throws Exception {
        //得到角色id集合
        List<Long> roleIds = userMapper.selectUserRoleIdsByUserId(userId);
        if (roleIds.size() == 1) {
            return roleIds.get(0);
        } else {
            return Collections.min(roleIds);
        }
    }

    @Override
    public List<User> getUsers() throws Exception {
        //查询所有用户集合
        return userMapper.selectUsers();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void addUser(User user) throws Exception {
        user.setSalt("dangyuan");
        user.setPassword("c457e86a78582277579a4de0bb21b57f");
        user.setScore(0);
        //插入t_user表
        userMapper.insertUser(user);
        Long userId = user.getId();
        System.out.println("userId=" + userId);
        //给user添加党员角色，设置t_user_role
        userMapper.addRole(userId);
        //所有消息info给到用户,当前2018年的
        List<Info> infos = infoMapper.selectInfos(DateUtil.getYear(new Date()));
        if (infos != null) {
            for (Info item : infos) {
                Map<String, Object> map = new HashMap<>();
                map.put("userId", userId);
                map.put("infoId", item.getId());
                map.put("year", item.getYear());
                infoMapper.insertUnReadedInfo(map);
            }
        }
        //为用户在各类不限次数安排表中加一条记录
        //1.党责中不限次数
        List<DangZe> dangZes = dangZeMapper.selectDangZes(DateUtil.getYear(new Date()));
        for (DangZe item : dangZes) {
            if (item.getRate() == 3) {
                //为用户在党责不限次数安排表中加一条记录
                String year = item.getYear();
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("userId", userId);
                map.put("year", year);
                map.put("dangzeId", item.getId());
                map.put("time", year + "-01-01 00:00:00");
                dangZeMapper.insertDangZe3Arrange(map);
            }
        }
        //2.社责中不限次数
        List<SheZe> sheZes = sheZeMapper.selectSheZes(DateUtil.getYear(new Date()));
        for (SheZe item : sheZes) {
            if (item.getRate() == 3) {
                //为用户在社责不限次数安排表中加一条记录
                String year = item.getYear();
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("userId", userId);
                map.put("year", year);
                map.put("shezeId", item.getId());
                map.put("time", year + "-01-01 00:00:00");
                sheZeMapper.insertSheZe3Arrange(map);
            }
        }
        //3.工作业绩不限次数
        List<Achievement> achievements = achievementMapper.selectAchievements(DateUtil.getYear(new Date()));
        for (Achievement item : achievements) {
            if (item.getRate() == 3) {
                //为用户在工作业绩不限次数安排表中加一条记录
                String year = item.getYear();
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("userId", userId);
                map.put("year", year);
                map.put("achievementId", item.getId());
                map.put("time", year + "-01-01 00:00:00");
                achievementMapper.insertAchievement3Arrange(map);
            }
        }
        //4.荣誉奖励不限次数
        List<HonorsAward> honorsAwards = honorsAwardMapper.selectHonorsAwards(DateUtil.getYear(new Date()));
        for (HonorsAward item : honorsAwards) {
            if (item.getRate() == 3) {
                //为用户在荣誉奖励不限次数安排表中加一条记录
                String year = item.getYear();
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("userId", userId);
                map.put("year", year);
                map.put("honorsAwardId", item.getId());
                map.put("time", year + "-01-01 00:00:00");
                honorsAwardMapper.insertHonorsAward3Arrange(map);
            }
        }
        //5.专业提升不限次数
        List<ProfessDevelop> professDevelops = professDevelopMapper.selectProfessDevelops(DateUtil.getYear(new Date()));
        for (ProfessDevelop item : professDevelops) {
            if (item.getRate() == 3) {
                //为用户在专业提升不限次数安排表中加一条记录
                String year = item.getYear();
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("userId", userId);
                map.put("year", year);
                map.put("professDevelopId", item.getId());
                map.put("time", year + "-01-01 00:00:00");
                professDevelopMapper.insertProfessDevelop3Arrange(map);
            }
        }
    }

    @Override
    public void resetPwd(Long userId) throws Exception {
        String password = CryptographyUtil.md5("123456", "dangyuan", 2);
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("password", password);
        map.put("salt", "dangyuan");
        userMapper.resetPwd(map);
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        return userMapper.selectUserById(userId);
    }


}
