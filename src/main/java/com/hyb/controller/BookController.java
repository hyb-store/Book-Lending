package com.hyb.controller;

import com.hyb.entity.Book;
import com.hyb.response.ResponseData;
import com.hyb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/detail")//根据bid查询书的所有信息
    public ResponseData  getDetail(Integer bid) {
        ResponseData responseData = null;
        if (bid == null) {
            return new ResponseData(0, "参数为空", null);
        }
        Book book = bookService.selectDetail(bid);
        responseData = new ResponseData(1, "成功", book);
        return responseData;
    }
}
