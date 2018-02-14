package com.telecom.jx.sjy.dangyuanback.service;

import com.telecom.jx.sjy.dangyuanback.pojo.po.ActivityAttachment;
import org.springframework.web.multipart.MultipartFile;

public interface ActivityAttachmentService {
    void uploadActivityImg(ActivityAttachment activityAttachment, MultipartFile multipartFile) throws Exception;
}
