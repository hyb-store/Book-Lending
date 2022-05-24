package com.hyb.controller;

import com.hyb.entity.Book;
import com.hyb.response.ResponseData;
import com.hyb.service.BookService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update")//修改书的信息
    public ResponseData updateBook(@RequestBody Book book) {
        ResponseData responseData = null;
        if (book.getBid() == null) {
            return new ResponseData(0, "书籍参数为空,修改失败", null);
        } else if (StringUtils.isEmpty(book.getBookName()) || StringUtils.isEmpty(book.getBookName()) || StringUtils.isEmpty(book.getPress())) {
            return new ResponseData(0, "书名或出版社为空,修改失败", null);
        } else if (bookService.selectBookByBid(book.getBid()) == null) {
            return new ResponseData(0, "不存在这本书", null);
        }
        bookService.updateBook(book);
        return new ResponseData(1, "修改成功", null);
    }

    @GetMapping("/deleteBook")//根据bid删除书的所有信息
    public ResponseData deleteMyBook(Integer bid) {
        ResponseData responseData = null;
        if (bid == null) {
            return new ResponseData(0, "参数为空", null);
        }
        bookService.deleteBook(bid);
        responseData = new ResponseData(1, "删除成功", null);
        return responseData;
    }
}
