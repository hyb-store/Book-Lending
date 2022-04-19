package com.hyb.service.impl;

import com.hyb.entity.Book;
import com.hyb.mapper.BookMapper;
import com.hyb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> selectMyBooks(Integer uid){
        List<Book> books = bookMapper.selectMyBooks(uid);
        return books;
    }
}
