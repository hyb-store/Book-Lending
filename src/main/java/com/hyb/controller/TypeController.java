package com.hyb.controller;

import com.hyb.entity.Book;
import com.hyb.entity.Type;
import com.hyb.response.ResponseData;
import com.hyb.service.TypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/all")
    public ResponseData selectAll() {
        ResponseData responseData = null;
        List<Type> types = typeService.selectAll();
        responseData = new ResponseData(1, "成功", types);

        return responseData;
    }

    @GetMapping("/tid")
    public ResponseData selectBookByTid (Integer tid) {
        ResponseData responseData = null;
        if (tid == null) {
            return new ResponseData(0, "参数为空", null);
        }
        List<Book> books = typeService.selectBookByTid(tid);

        responseData = new ResponseData(1, "成功", books);
        return responseData;
    }
}
