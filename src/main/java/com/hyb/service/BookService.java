package com.hyb.service;

import com.hyb.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> selectMyBooks(Integer uid);

    //根据bid查询书的所有信息
    Book selectDetail(Integer bid);
}
