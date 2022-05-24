package com.hyb.controller;

import com.baidu.aip.ocr.AipOcr;
import com.hyb.config.OcrProperties;
import com.hyb.entity.Book;
import com.hyb.entity.History;
import com.hyb.entity.User;
import com.hyb.mapper.HistoryMapper;
import com.hyb.response.ResponseData;
import com.hyb.service.BorrowService;
import com.hyb.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private AipOcr client;

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private UserService userService;

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

    @PostMapping("/upload") //我要借出图书
    public ResponseData uploadFile (@RequestParam(name = "file", required = false) MultipartFile file,
                                    @RequestParam(name = "book", required = false) String book) {
        ResponseData responseData = null;
        if (file == null) {
            return new ResponseData(0, "文件为空", null);
        } else if (StringUtils.isEmpty(book)) {
            return new ResponseData(0, "图书参数为空", null);
        }
        //获取要上传文件的名称
        String fileName = file.getOriginalFilename();
        //如果名称为空，返回一个文件名为空
        if (StringUtils.isEmpty(fileName) || file == null){
            return new ResponseData(0, "文件或文件名为空", null);
        }
        Book boo = com.alibaba.fastjson.JSONObject.parseObject(book, Book.class);
        if (boo.getUid() == null || boo.getUid() <= 0) {
            return new ResponseData(0, "用户参数为空", null);
        }
        if (StringUtils.isEmpty(boo.getBookName()) || StringUtils.isEmpty(boo.getPress())) {
            return new ResponseData(0, "书名或出版社为空", null);
        }
        responseData = new ResponseData(1, "成功", null);
        borrowService.insertNewBook(file, boo);
        return responseData;
    }

    @PostMapping("/borrow")//借书
    public ResponseData borrowBook(@RequestBody History history) {
        ResponseData responseData = null;
        if (history.getbUid() == null || history.getlUid() == null) {
            return new ResponseData(0, "用户参数为空", null);
        } else if (history.getBid() == null){
            return new ResponseData(0, "book参数为空", null);
        } else if (history.getEndTime() == null) {
            return new ResponseData(0, "时间参数为空", null);
        } else if (userService.selectScoresByUid(history.getbUid()) < 0) {
            return new ResponseData(0, "积分为负，无法借书", null);
        }
        User user = borrowService.borrowBook(history);
        responseData = new ResponseData(1, "借书成功,联系方式为：", user);
        return responseData;
    }


//    @PostMapping("/test")
//    public ResponseData Test(@RequestBody History history) {
//        System.out.println(history.getEndTime());
//       return new ResponseData(1,"success",history.getEndTime() );
//    }

    @GetMapping("/borrowOk")//借书确认
    public ResponseData borrowBookOk(Integer bid) {
        if (bid == null) {
            return new ResponseData(0, "参数为空", null);
        }
        borrowService.borrowBookOK(bid);
        return new ResponseData(1, "确定借书成功", null);
    }

//    @GetMapping("/return")//还书
//    public ResponseData returnBook(Integer hid) {
//        if (hid == null) {
//            return new ResponseData(0, "参数为空", null);
//        }
//        borrowService.returnBook(hid);
//        return new ResponseData(1, "还书成功", null);
//    }
//
//    @GetMapping("/returnOk")//还书确定
//    public ResponseData returnBookOK(Integer bid) {
//        if (bid == null) {
//            return new ResponseData(0, "参数为空", null);
//        }
//        borrowService.returnBookOK(bid);
//        return new ResponseData(1, "确定还书成功", null);
//    }

    @GetMapping("/returnOk")//还书确定
    public ResponseData returnBookOK(Integer hid) {
        if (hid == null) {
            return new ResponseData(0, "参数为空", null);
        }
        borrowService.returnBookOK(hid);
        return new ResponseData(1, "确定还书成功", null);
    }
}
