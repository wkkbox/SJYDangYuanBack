package com.telecom.jx.sjy.dangyuanback.service;


import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.Score;
import com.telecom.jx.sjy.dangyuanback.util.dto.Menu;
import com.telecom.jx.sjy.dangyuanback.util.dto.PageBean;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> showUsers() throws Exception;

    List<User> getUserByUserName(String userName) throws Exception;

    List<Long> getUserRolesByUserId(Long userId) throws Exception;

    Set<String> getUserPermissionsByUserId(Long userId) throws Exception;

    List<Menu> getMenusByUserId(Long userId) throws Exception;

    User getUserByAccountName(String accountName) throws Exception;

    List<Score> getScorePublicity() throws Exception;

    PageBean<Score> getScorePublicityByPage(Integer currentPage, Integer pageSize) throws Exception;

    Long getUserHighRoleByUserId(Long userId) throws Exception;
}
