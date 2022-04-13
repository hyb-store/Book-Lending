package com.hyb.controller;

import com.baidu.aip.ocr.AipOcr;
import com.hyb.config.OcrProperties;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private OcrProperties ocr;

    @PostMapping("/ocr")
    public String file (MultipartFile file) throws IOException {
        System.err.println("文件是否为空 ： " + file.isEmpty());
        System.err.println("文件的大小为 ：" + file.getSize());
        System.err.println("文件的媒体类型为 ： " + file.getContentType());
        System.err.println("文件的名字： " + file.getName());
        System.err.println("文件的originName为： " + file.getOriginalFilename());

        byte[] bytes = file.getBytes();

        // 初始化一个AipOcr
        AipOcr client = new AipOcr(ocr.getAPP_ID(), ocr.getAPI_KEY(), ocr.getSECRET_KEY());
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");//中英文混合
        //options.put("detect_direction", "true");//检测图像朝向
        //options.put("detect_language", "true");//检测语言
        //options.put("probability", "true");//返回识别结果中每一行的置信度

        JSONObject res = client.basicGeneral(bytes, options);

        System.out.println(res.toString(2));
        return res.toString();
    }
}
