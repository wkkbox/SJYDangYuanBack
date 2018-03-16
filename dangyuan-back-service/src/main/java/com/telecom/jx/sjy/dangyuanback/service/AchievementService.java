package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.Achievement;
import com.telecom.jx.sjy.dangyuanback.pojo.po.AchievementContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.AchievementArrangeCustom;

import java.util.List;
import java.util.Map;

public interface AchievementService {
    List<Achievement> getAchievements() throws Exception;

    Achievement getAchievementById(Long achievementId) throws Exception;

    void editAchievement(Achievement achievement) throws Exception;

    void addAchievement(Achievement achievement) throws Exception;

    List<AchievementContent> getAchievementContents() throws Exception;

    AchievementArrangeCustom getAchievementArrangeCustom(Long arrangeId) throws Exception;

    AchievementArrangeCustom getAchievement3ArrangeCustom(Long arrangeId) throws Exception;

    void passAchievement(Map<String, Object> map) throws Exception;

    void noPassAchievement(Long userAchievementId, Map<String, Object> map) throws Exception;
}
