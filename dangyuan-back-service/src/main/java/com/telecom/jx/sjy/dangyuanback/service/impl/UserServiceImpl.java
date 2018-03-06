package com.telecom.jx.sjy.dangyuanback.service.impl;


import com.telecom.jx.sjy.dangyuanback.mapper.DangZeMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.InfoMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.SheZeMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.UserMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;
import com.telecom.jx.sjy.dangyuanback.pojo.po.SheZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
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
    public List<Score> getScorePublicity() throws Exception {
        return userMapper.selectScorePublicity();
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
        for(SheZe item : sheZes){
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
}
