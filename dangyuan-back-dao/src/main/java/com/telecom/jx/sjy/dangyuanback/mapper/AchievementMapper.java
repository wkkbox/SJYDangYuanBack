package com.telecom.jx.sjy.dangyuanback.mapper;

import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;

import java.util.List;
import java.util.Map;

public interface AchievementMapper {
    List<Achievement> selectAchievements(Integer year);

    Achievement selectAchievementById(Long achievementId);

    void updateAchievement(Achievement achievement);

    void insertAchievement(Achievement achievement);

    void insertAchievementArrange(Map<String, Object> map);

    void insertAchievement3Arrange(Map<String, Object> map);
}
