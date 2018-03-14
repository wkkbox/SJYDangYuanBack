package com.telecom.jx.sjy.dangyuanback.mapper;


import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZe;
import com.telecom.jx.sjy.dangyuanback.pojo.po.DangZeContent;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.DangZeArrangeCustom;

import java.util.List;
import java.util.Map;

public interface DangZeMapper {
    List<DangZe> selectDangZes(Integer year);

    Integer selectDangZeState(Map<String, Object> map);

    void insertDangZe3Arrange(Map<String, Object> map);

    void insertDangZe(DangZe dangZe);

    void insertDangZeArrange(Map<String, Object> map);

    DangZe selectDangZeById(Long dangzeId);

    void updateDangZe(DangZe dangZe);

    List<DangZeContent> selectDangZeContents(Map<String, Object> map);

    DangZeArrangeCustom selectDangZeArrangeCustom(Long arrangeId);

    DangZeArrangeCustom selectDangZe3ArrangeCustom(Long arrangeId);

    Long selectUserDangZeId(Map<String, Object> map);

    String selectCommitTime(Long userDangzeId);

    Integer selectUserDangZeState(Map<String, Object> map);

    void passDangZe(Map<String, Object> map);

    void noPassDangZe(Long userDangzeId);
}
