package com.hyb.config;

import com.baidu.aip.ocr.AipOcr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class OcrConfig {

    @Autowired
    private OcrProperties ocr;

    @Bean
    public AipOcr getAipOcr () {
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(ocr.getAPP_ID(), ocr.getAPI_KEY(), ocr.getSECRET_KEY());
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        return client;
    }
}
