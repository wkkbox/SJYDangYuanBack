package com.telecom.jx.sjy.dangyuanback.service.impl;


import com.telecom.jx.sjy.dangyuanback.mapper.ActivityAttachmentMapper;
import com.telecom.jx.sjy.dangyuanback.pojo.po.ActivityAttachment;
import com.telecom.jx.sjy.dangyuanback.service.ActivityAttachmentService;
import com.telecom.jx.sjy.dangyuanback.util.IDUtils;
import com.telecom.jx.sjy.dangyuanback.util.PropKit;
import com.telecom.jx.sjy.dangyuanback.util.Utility;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ActivityAttachmentServiceImpl implements ActivityAttachmentService {

    @Autowired
    private ActivityAttachmentMapper activityAttachmentMapper;

    @Override
    public void uploadActivityImg(ActivityAttachment activityAttachment, MultipartFile multipartFile) throws Exception {
        System.out.println("multipartFile=" + multipartFile);
        //复制文件
        String originalFilename = multipartFile.getOriginalFilename();//文件名
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));//后缀
        String newName = IDUtils.genImageName() + fileType;
        String filePath = new DateTime().toString("yyyyMMdd/");
        String basePath = PropKit.use("config.properties").get("config.fileBasePath");
        // 不存在文件夹创建文件夹
        Utility.makeDirectory(basePath + filePath);
        String newFilePath = basePath + filePath + newName;
        File file = new File(newFilePath);
        FileCopyUtils.copy(multipartFile.getBytes(), file);// 文件上传后存放的位置
        //插入activityAttachment表
        activityAttachment.setServerAddress(activityAttachment.getServerAddress() + "/" + newFilePath);//图片在服务器上的地址
        activityAttachmentMapper.insertActivityAttachment(activityAttachment);
    }
}
