package com.hyb.controller;

import com.alibaba.fastjson.JSONObject;
import com.hyb.config.WxLoginProperties;
import com.hyb.entity.Book;
import com.hyb.entity.History;
import com.hyb.entity.User;
import com.hyb.response.ResponseData;
import com.hyb.response.WxLogin;
import com.hyb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WxLoginProperties wx;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

/*    @GetMapping("/login")
    public ResponseData login (String code) throws IOException {
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
        ResponseData responseData = null;
        if (code == null || "".equals(code)) {
            return new ResponseData(0, "登录失败！", null);
        }

        String url = wx.getUrl();
        String forObject = restTemplate.getForObject(url, String.class, code);
        System.out.println(forObject);
        WxLogin wxLogin = JSONObject.parseObject(forObject, WxLogin.class);

        if (wxLogin.getErrcode() != null || wxLogin.getErrmsg() != null) {
            if ("40163".equals(wxLogin.getErrcode())) {
                return new ResponseData(0, "code been used", null);
            } else if ("40029".equals(wxLogin.getErrcode())) {
                return new ResponseData(0, "invalid code", null);
            } else {
                return new ResponseData(0, "登陆失败", null);
            }
        }
        User user = userService.selectUserByOpenId(wxLogin.getOpenId());
        if (user == null) {
            User us = new User();
            us.setOpenId(wxLogin.getOpenId());
            return new ResponseData(0, "请先完善个人信息", us);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("wxLogin", wxLogin);
        map.put("user", user);

        responseData = new ResponseData(1, "登录成功！", map);
        return responseData;
    }

    @PostMapping("/register") //注册
    public ResponseData register (@RequestBody User user) {
        ResponseData responseData = null;
        if (user.getOpenId() == null || "".equals(user.getOpenId())) {
            return new ResponseData(0, "openId为空", null);
        } else if (user.getUsername() == null || "".equals(user.getUsername())) {
            return new ResponseData(0, "用户名为空", null);
        } else if (user.getPhoneNum() == null || "".equals(user.getPhoneNum())) {
            return new ResponseData(0, "电话号码为空", null);
        }
        if ((userService.selectUserByOpenId(user.getOpenId())) == null) {
            //新用户插入
            userService.insertUser(user);
            responseData = new ResponseData(1, "注册成功", userService.selectUserByOpenId(user.getOpenId()));
        } else {
            responseData = new ResponseData(0, "该用户已存在", null);
        }
        return responseData;
    }

    @PostMapping("/perfect")//完善个人信息
    public ResponseData perfect(@RequestBody User user) {
        ResponseData responseData = null;
        if (user.getOpenId() == null || "".equals(user.getOpenId())) {
            return new ResponseData(0, "openId为空", null);
        } else if (user.getUsername() == null || "".equals(user.getUsername())) {
            return new ResponseData(0, "用户名为空", null);
        } else if (user.getPhoneNum() == null || "".equals(user.getPhoneNum())) {
            return new ResponseData(0, "电话号码为空", null);
        } else if ((userService.selectUserByOpenId(user.getOpenId())) == null) {
            return new ResponseData(1, "该用户不存在", null);
        }
        userService.updateUser(user);
        responseData = new ResponseData(1, "完善信息成功", userService.selectUserByOpenId(user.getOpenId()));
        return responseData;
    }*/

    @GetMapping("/login")//登录获取openid，并插入数据如插入
    public ResponseData login (String code) throws IOException {
        ResponseData responseData = null;
        if (code == null || "".equals(code)) {
            return new ResponseData(0, "登录失败！", null);
        }

        String url = wx.getUrl();
        String forObject = restTemplate.getForObject(url, String.class, code);
        System.out.println(forObject);
        WxLogin wxLogin = JSONObject.parseObject(forObject, WxLogin.class);

        if (wxLogin.getErrcode() != null || wxLogin.getErrmsg() != null) {//有错误
            if ("40163".equals(wxLogin.getErrcode())) {
                return new ResponseData(0, "code been used", null);
            } else if ("40029".equals(wxLogin.getErrcode())) {
                return new ResponseData(0, "invalid code", null);
            } else {
                return new ResponseData(0, "登陆失败", null);
            }
        }
        User user = userService.selectUserByOpenId(wxLogin.getOpenId());
        if (user == null) { //没有该用户，首次登陆插入openId
            user = new User();
            user.setOpenId(wxLogin.getOpenId());
            //新用户插入
            userService.insertUser(user);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("wxLogin", wxLogin);
        map.put("user", user);

        responseData = new ResponseData(1, "登录成功！", map);
        return responseData;
    }

    @PostMapping("/perfect")//完善个人信息
    public ResponseData perfect(@RequestBody User user) {
        System.out.println(user);
        ResponseData responseData = null;
        if (user.getOpenId() == null || "".equals(user.getOpenId())) {
            return new ResponseData(0, "openId为空", null);
        } else if (user.getUsername() == null || "".equals(user.getUsername())) {
            return new ResponseData(0, "用户名为空", null);
        } else if (user.getPhoneNum() == null || "".equals(user.getPhoneNum())) {
            return new ResponseData(0, "电话号码为空", null);
        } else if ((userService.selectUserByOpenId(user.getOpenId())) == null) {
            return new ResponseData(1, "该用户不存在", null);
        }
        userService.updateUser(user);
        responseData = new ResponseData(1, "保存成功", userService.selectUserByOpenId(user.getOpenId()));
        return responseData;
    }

    @GetMapping("/myBook")//我的书
    public ResponseData getMyBook(String openId) {
        Integer uid;
        ResponseData responseData = null;
        if (openId == null || "".equals(openId)) {
            return new ResponseData(0, "参数为空！", null);
        } else if ((uid = userService.idByOpenId(openId)) == null) {
            return new ResponseData(0, "该用户不存在！", null);
        }
        List<Book> myBooks = userService.getMyBook(uid);
        responseData = new ResponseData(1, "查询成功", myBooks);
        return responseData;
    }

    @GetMapping("/myLend")//借出记录
    public ResponseData getMyLendRecord (String openId) {
        Integer uid;
        ResponseData responseData = null;
        if (openId == null || "".equals(openId)) {
            return new ResponseData(0, "参数为空！", null);
        } else if ((uid = userService.idByOpenId(openId)) == null) {
            return new ResponseData(0, "该用户不存在！", null);
        }
        List<History> myLendRecord = userService.getMyLendRecord(uid);
        responseData = new ResponseData(1, "查询成功", myLendRecord);
        return responseData;
    }

    @GetMapping("/myBorrow")//借入记录
    public ResponseData getMyBorrowRecord (String openId) {
        Integer uid;
        ResponseData responseData = null;
        if (openId == null || "".equals(openId)) {
            return new ResponseData(0, "参数为空！", null);
        } else if ((uid = userService.idByOpenId(openId)) == null) {
            return new ResponseData(0, "该用户不存在！", null);
        }
        List<History> myBorrowRecord = userService.getMyBorrowRecord(uid);
        responseData = new ResponseData(1, "查询成功", myBorrowRecord);
        return responseData;
    }
}
