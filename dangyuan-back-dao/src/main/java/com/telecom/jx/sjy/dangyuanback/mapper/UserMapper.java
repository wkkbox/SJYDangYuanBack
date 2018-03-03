package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.Score;
import com.telecom.jx.sjy.dangyuanback.util.dto.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserMapper {
    List<User> listUsers();

    List<User> selectUserByUserName(String userName);

    User selectUserByAccountName(String accountName);

    Set<String> selectUserRolesByUserId(Long userId);

    List<Long> selectUserRoleIdsByUserId(Long userId);

    List<String> selectUserPermissionsByUserId(Long userId);

    List<Menu> selectMenusByUserId(Long userId);

    List<Score> selectScorePublicity();

    Integer selectScorePublicitySize();

    List<Score> selectScorePublicityByPage(Map<String, Object> map);

    Integer selectUserCount();

    List<User> selectUserByPage(Map<String, Object> map);

    List<User> selectUsers();

    void insertUser(User user);

    void addRole(Long userId);
}
