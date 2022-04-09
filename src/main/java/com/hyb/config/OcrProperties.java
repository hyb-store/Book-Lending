package com.hyb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ocr")
public class OcrProperties {

    //设置APPID/AK/SK
    private String APP_ID;
    private String API_KEY;
    private String SECRET_KEY;

    public OcrProperties() {
    }

    public OcrProperties(String APP_ID, String API_KEY, String SECRET_KEY) {
        this.APP_ID = APP_ID;
        this.API_KEY = API_KEY;
        this.SECRET_KEY = SECRET_KEY;
    }

    public String getAPP_ID() {
        return APP_ID;
    }

    public void setAPP_ID(String APP_ID) {
        this.APP_ID = APP_ID;
    }

    public String getAPI_KEY() {
        return API_KEY;
    }

    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    public String getSECRET_KEY() {
        return SECRET_KEY;
    }

    public void setSECRET_KEY(String SECRET_KEY) {
        this.SECRET_KEY = SECRET_KEY;
    }
}
