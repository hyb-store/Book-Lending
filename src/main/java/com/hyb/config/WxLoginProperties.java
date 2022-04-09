package com.hyb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wx.login")
public class WxLoginProperties {

    //appid
    private String appId;
    //密钥
    private String secret;

    public WxLoginProperties() {
    }

    public WxLoginProperties(String appId, String secret) {
        this.appId = appId;
        this.secret = secret;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
