package com.hyb.service;

import com.hyb.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> selectMyBooks(Integer uid);
}
