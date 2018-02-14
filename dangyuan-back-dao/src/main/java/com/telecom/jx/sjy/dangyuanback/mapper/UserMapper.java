package com.telecom.jx.sjy.dangyuanback.mapper;



import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.Score;
import com.telecom.jx.sjy.dangyuanback.util.dto.Menu;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserMapper {
    List<User> listUsers() throws Exception;

    List<User> selectUserByUserName(String userName) throws Exception;

    User selectUserByAccountName(String accountName) throws Exception;

    List<Long> selectUserRolesByUserId(Long userId) throws Exception;

    Set<String> selectUserPermissionsByUserId(Long userId) throws Exception;

    List<Menu> selectMenusByUserId(Long userId) throws Exception;

    List<Score> selectScorePublicity() throws Exception;

    Integer selectScorePublicitySize() throws Exception;

    List<Score> selectScorePublicityByPage(Map<String, Object> map) throws Exception;
}
