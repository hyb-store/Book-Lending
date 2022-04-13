package com.hyb.controller;

import com.hyb.config.WxLoginProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WxLoginProperties wx;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login")
    public String login () throws IOException {
//        //code
//        String code = "041LOv0w3CAdiY2Qdy1w3u1fhQ0LOv0A";
//        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+wx.getAppId()
//                +"&secret="+wx.getSecret()+"&js_code="+code+"&grant_type=authorization_code";
//
//        //客户端
//        OkHttpClient client = new OkHttpClient();
//        //用url发起请求
//        Request request = new Request.Builder().url(url).build();
//        //拿到响应
//        Response response = client.newCall(request).execute();
//        //如果响应成功，打印返回值
//        if (response.isSuccessful()){
//            String body = response.body().string();
//            System.out.println(body);
//            //实际开发应该有的步骤：
//            //1.入库：把openId存起来
//            //2.返回一个token
//        }
//        //因为是简易版，所以返回值没用到
//        return response.toString();

        String code = "0718v3Ha1XKOYC08FPGa1TnSdn18v3HO";
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid="+wx.getAppId()
                +"&secret="+wx.getSecret()+"&js_code={1}&grant_type=authorization_code";
        String forObject = restTemplate.getForObject(url, String.class, code);
        return forObject.toString();
    }
}
