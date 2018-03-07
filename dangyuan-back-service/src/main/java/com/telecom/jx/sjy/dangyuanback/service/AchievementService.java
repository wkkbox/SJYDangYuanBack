package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;

import java.util.List;

public interface AchievementService {
    List<Achievement> getAchievements() throws Exception;

    Achievement getAchievementById(Long achievementId) throws Exception;

    void editAchievement(Achievement achievement) throws Exception;

    void addAchievement(Achievement achievement) throws Exception;
}
