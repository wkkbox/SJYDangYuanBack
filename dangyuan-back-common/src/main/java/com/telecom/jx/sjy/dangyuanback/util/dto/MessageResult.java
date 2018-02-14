package com.telecom.jx.sjy.dangyuanback.util.dto;

/**
 * 处理消息结果的DTO
 */
public class MessageResult {
    private boolean success;
    private String msg;
    private Object data;

    public MessageResult(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public MessageResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
