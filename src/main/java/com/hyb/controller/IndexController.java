package com.hyb.controller;

import com.hyb.entity.Book;
import com.hyb.response.ResponseData;
import com.hyb.service.IndexService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getTop5")
    public ResponseData getTop5() {
        ResponseData responseData = null;

        responseData = new ResponseData(1, "成功", null);
        return responseData;
    }

    @GetMapping("/recommend") //获取主页推荐
    public ResponseData getRecommend(Long uid) {
        ResponseData responseData = null;

        List<Book> recommend = indexService.getRecommend(uid, 6);

        responseData = new ResponseData(1, "成功", recommend);
        return responseData;
    }
}
