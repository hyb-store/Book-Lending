package com.hyb.mapper;

import com.hyb.entity.Book;
import com.hyb.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    List<Book> selectMyBooks(Integer uid);

}
