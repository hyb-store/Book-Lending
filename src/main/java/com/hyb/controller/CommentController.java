package com.hyb.controller;

import com.hyb.entity.Comment;
import com.hyb.response.ResponseData;
import com.hyb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add") //评论
    public ResponseData search (@RequestBody Comment comment){
        ResponseData responseData = null;
        if (comment.getUid() == null || comment.getBid() == null) {
            return new ResponseData(0, "uid或bid参数为空", null);
        } else if (comment.getContent() == null) {
            return new ResponseData(0, "内容为空", null);

        }
        bookService.insertComment(comment);
        responseData = new ResponseData(1, "评论成功", null);
        return responseData;
    }

    @GetMapping("/deleteComment")//根据bid删除书的所有信息
    public ResponseData deleteComment(Integer cid) {
        ResponseData responseData = null;
        if (cid == null) {
            return new ResponseData(0, "参数为空", null);
        }
        bookService.deleteComment(cid);
        responseData = new ResponseData(1, "删除成功", null);
        return responseData;
    }
}
