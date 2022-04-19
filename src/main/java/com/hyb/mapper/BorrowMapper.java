package com.hyb.mapper;

import com.hyb.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BorrowMapper {

    void insertNewBook(Book book);

}
