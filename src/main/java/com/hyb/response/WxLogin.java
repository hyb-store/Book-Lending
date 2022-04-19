package com.hyb.response;

import java.io.Serializable;

public class WxLogin implements Serializable {

    private String sessionKey;
    private String openId;
    private String errcode;
    private String errmsg;

    public WxLogin() {
    }

    public WxLogin(String sessionKey, String openId, String errcode, String rid) {
        this.sessionKey = sessionKey;
        this.openId = openId;
        this.errcode = errcode;
        this.errmsg = rid;
    }

    @Override
    public String toString() {
        return "WxLogin{" +
                "sessionKey='" + sessionKey + '\'' +
                ", openId='" + openId + '\'' +
                ", errcode='" + errcode + '\'' +
                ", rid='" + errmsg + '\'' +
                '}';
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
