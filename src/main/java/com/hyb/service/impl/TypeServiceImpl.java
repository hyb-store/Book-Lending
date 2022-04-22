package com.hyb.service.impl;

import com.hyb.entity.Book;
import com.hyb.entity.Type;
import com.hyb.mapper.BookMapper;
import com.hyb.mapper.BorrowMapper;
import com.hyb.mapper.TypeMapper;
import com.hyb.service.BookService;
import com.hyb.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Type> selectAll() {
        List<Type> types = typeMapper.selectAll();
        return types;
    }

    @Override
    public List<Book> selectBookByTid(Integer tid) {
        return bookMapper.selectBookByTid(tid);
    }
}
