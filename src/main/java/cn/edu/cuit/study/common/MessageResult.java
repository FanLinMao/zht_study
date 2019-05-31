package cn.edu.cuit.study.common;

import cn.edu.cuit.study.constant.ResponseCode;

/**
 * @date: 2019/5/31
 * @author: Flemming
 * @description: 消息体
 */
public class MessageResult {

    /**
     * 提示消息
     */
    private String message;

    /**
     * 状态码
     */
    private int code;

    /**
     * 要返回的数据
     */
    private Object data;

    public MessageResult(int code, Object data) {
        this("", code, data);
    }

    public MessageResult(String message, int code, Object data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
