package com.hyb.service;

import com.hyb.entity.Book;
import com.hyb.entity.Type;

import java.util.List;

public interface TypeService {

    List<Type> selectAll();

    List<Book> selectBookByTid(Integer tid);
}
