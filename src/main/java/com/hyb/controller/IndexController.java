package com.hyb.controller;

import com.hyb.entity.Book;
import com.hyb.response.ResponseData;
import com.hyb.service.IndexService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/search") //搜索
    public ResponseData search (String data) {
        ResponseData responseData = null;
        if (StringUtils.isEmpty(data)) {
            return new ResponseData(0, "参数为空", null);
        }
        List<Book> search = indexService.search(data);
        responseData = new ResponseData(1, "成功", search);
        return responseData;
    }

    @GetMapping("/getTop3")
    public ResponseData getTop3() {
        ResponseData responseData;
        List<Book> top3 = indexService.getTop3();
        responseData = new ResponseData(1, "成功", top3);
        return responseData;
    }

    @GetMapping("/recommend") //获取主页推荐
    public ResponseData getRecommend(@RequestParam(name = "uid", required = false)Long uid,
                                    @RequestParam(name = "data", required = false)String data) {
        ResponseData responseData = null;
        List<Book> recommend;
        if (uid == null && data != null) {//只有data,直接返回
            return new ResponseData(0, "参数为空", null);
        } else if (uid == null && data == null) {//都为空，随机推荐
            //随机推荐
            recommend = indexService.getRandomRecommend(6);
            responseData = new ResponseData(1, "成功", recommend);
        } else if (uid != null && data == null) {//只有uid，协同过滤
            //根据用户uid，进行recommend
            recommend = indexService.getRecommend(uid, 6);
            Collections.shuffle(recommend);
            responseData = new ResponseData(1, "成功", recommend);
        } else if (uid != null && data != null) {
            //根据用户选择和recommend推荐
            recommend = indexService.getDRRecommend(uid, data, 6);
            Collections.shuffle(recommend);
            responseData = new ResponseData(1, "成功", recommend);
        }
        return responseData;
    }
}
