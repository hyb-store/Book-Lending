package com.hyb.controller;

import com.baidu.aip.ocr.AipOcr;
import com.hyb.config.OcrProperties;
import com.hyb.entity.Book;
import com.hyb.response.ResponseData;
import com.hyb.service.BorrowService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private AipOcr client;

    @Autowired
    private BorrowService borrowService;

    @PostMapping("/ocr")
    public ResponseData file (MultipartFile file) throws IOException {
        ResponseData responseData = null;
        if (file.isEmpty()) {
            return new ResponseData(0, "文件为空！", null);
        }
        System.err.println("文件是否为空 ： " + file.isEmpty());
        System.err.println("文件的大小为 ：" + file.getSize());
        System.err.println("文件的媒体类型为 ： " + file.getContentType());
        System.err.println("文件的名字： " + file.getName());
        System.err.println("文件的originName为： " + file.getOriginalFilename());

        byte[] bytes = file.getBytes();

        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");//中英文混合
        //options.put("detect_direction", "true");//检测图像朝向
        //options.put("detect_language", "true");//检测语言
        //options.put("probability", "true");//返回识别结果中每一行的置信度

        JSONObject res = client.basicGeneral(bytes, options);

        //System.out.println(res.toString(2));
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(res.toString(2));
        responseData = new ResponseData(1, "成功", jsonObject);
        return responseData;
    }

    @PostMapping("/upload")
    public ResponseData uploadFile (@RequestParam("file") MultipartFile file, @RequestParam("book") String book) {
        ResponseData responseData = null;
        //获取要上传文件的名称
        String fileName = file.getOriginalFilename();
        //如果名称为空，返回一个文件名为空
        if (StringUtils.isEmpty(fileName)){
            return new ResponseData(0, "文件名为空", null);
        }
        Book boo = com.alibaba.fastjson.JSONObject.parseObject(book, Book.class);
        if (boo.getUid() == null || boo.getUid() <= 0) {
            return new ResponseData(0, "用户参数为空", null);
        }
        if (StringUtils.isEmpty(boo.getBookName()) || StringUtils.isEmpty(boo.getPress())) {
            return new ResponseData(0, "书名或出版社为空", null);
        }

        borrowService.insertNewBook(file, boo);

        return responseData;
    }
}
