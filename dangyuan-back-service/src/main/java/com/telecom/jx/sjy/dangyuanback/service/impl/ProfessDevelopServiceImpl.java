package com.telecom.jx.sjy.dangyuanback.service.impl;

import com.telecom.jx.sjy.dangyuanback.mapper.InfoMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.ProfessDevelopMapper;
import com.telecom.jx.sjy.dangyuanback.mapper.UserMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.Info;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelop;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ProfessDevelopContent;
import com.telecom.jx.sjy.dangyuanback.pojo.po.User;
import com.telecom.jx.sjy.dangyuanback.pojo.vo.ProfessDevelopArrangeCustom;
import com.telecom.jx.sjy.dangyuanback.service.ProfessDevelopService;
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
public class ProfessDevelopServiceImpl implements ProfessDevelopService {

    @Autowired
    private ProfessDevelopMapper professDevelopMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;

    @Override
    public List<ProfessDevelop> getProfessDevelops() throws Exception {
        //查询所有专业提升集合
        Integer year = DateUtil.getYear(new Date());
        return professDevelopMapper.selectProfessDevelops(year);
    }

    @Override
    public ProfessDevelop getProfessDevelopById(Long professDevelopId) throws Exception {
        return professDevelopMapper.selectProfessDevelopById(professDevelopId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void editProfessDevelop(ProfessDevelop professDevelop) throws Exception {
        professDevelopMapper.updateProfessDevelop(professDevelop);
    }

    @Override
    public void addProfessDevelop(ProfessDevelop professDevelop) throws Exception {
        //在专业提升表添加一条记录
        String year = String.valueOf(DateUtil.getYear(new Date()));
        professDevelop.setYear(year);
        professDevelop.setPublishTime(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss"));
        professDevelop.setRoleId((long) 3);
        professDevelop.setlScore(professDevelop.getdScore());
        professDevelop.sethScore(professDevelop.getdScore());
        professDevelopMapper.insertProfessDevelop(professDevelop);
        Long professDevelopId = professDevelop.getId();
        System.out.println("professDevelopId=" + professDevelopId);
        //无限次数和不是无限次数
        if (professDevelop.getRate() == 0) {//不是无限次数的情况,0表示每月一次
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
                map.put("professDevelopId", professDevelopId);
                professDevelopMapper.insertProfessDevelopArrange(map);
            }
        } else if (professDevelop.getRate() == 1) {//不是无限次数的情况,1表示每季度一次
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
                map.put("professDevelopId", professDevelopId);
                professDevelopMapper.insertProfessDevelopArrange(map);
            }
        } else if (professDevelop.getRate() == 2) {//不是无限次数的情况,2表示每年一次
            for (int i = 1; i <= 12; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("month", year + i);
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("professDevelopId", professDevelopId);
                professDevelopMapper.insertProfessDevelopArrange(map);
            }
        } else if (professDevelop.getRate() == 3) {//无限次数的情况
            List<User> users = userMapper.selectUsers();
            for (User item : users) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", IDUtils.getItemId());
                map.put("year", year);
                map.put("userId", item.getId());
                map.put("time", year + "-01" + "-01 00:00:00");
                map.put("professDevelopId", professDevelopId);
                professDevelopMapper.insertProfessDevelop3Arrange(map);
            }
        }
        //发布的工作业绩给所有用户添加消息
        //在t_info表添加一条记录,先判断
        /*Map<String, Object> map_ = new HashMap<>();
        map_.put("title", professDevelop.getTitle());
        map_.put("content", professDevelop.getContent());
        if (infoMapper.selectInfoByTitleAndContent(map_) == null) {
            Info info = new Info();
            info.setTitle(professDevelop.getTitle());
            info.setContent(professDevelop.getContent());
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
    public List<ProfessDevelopContent> getProfessDevelopContents() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("year",String.valueOf(DateUtil.getYear(new Date())));
        List<ProfessDevelopContent> professDevelopContents=professDevelopMapper.selectProfessDevelopContents(map);
        return professDevelopContents;
    }

    @Override
    public ProfessDevelopArrangeCustom getProfessDevelopArrangeCustom(Long arrangeId) throws Exception {
        return professDevelopMapper.selectProfessDevelopArrangeCustom(arrangeId);
    }

    @Override
    public ProfessDevelopArrangeCustom getProfessDevelop3ArrangeCustom(Long arrangeId) throws Exception {
        return professDevelopMapper.selectProfessDevelop3ArrangeCustom(arrangeId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void passProfessDevelop(Map<String, Object> map) throws Exception {
        if ((int) map.get("otherAttr") == 1) {
            map.put("title","(国家级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 2) {
            map.put("title","(省部级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 3) {
            map.put("title","(地市级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 4) {
            map.put("title","(集团(中央企业)级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 5) {
            map.put("title","(省公司级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 6) {
            map.put("title","(市公司级)"+map.get("title"));
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
        professDevelopMapper.passProfessDevelop(map);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void noPassProfessDevelop(Long userProfessDevelopId, Map<String, Object> map) throws Exception {
        if ((int) map.get("otherAttr") == 1) {
            map.put("title","(国家级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 2) {
            map.put("title","(省部级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 3) {
            map.put("title","(地市级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 4) {
            map.put("title","(集团(中央企业)级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 5) {
            map.put("title","(省公司级)"+map.get("title"));
        }
        if ((int) map.get("otherAttr") == 6) {
            map.put("title","(市公司级)"+map.get("title"));
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
        professDevelopMapper.noPassProfessDevelop(userProfessDevelopId);
    }
}
