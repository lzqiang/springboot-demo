package com.tritonsfs.springboot.exception;

/**
 * @author 2018/9/29 14:28 by 刘赵强
 **/
public class RetryException extends RuntimeException {
    private String code;
    private String msg;
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}