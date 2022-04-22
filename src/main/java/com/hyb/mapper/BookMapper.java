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

    /**
     * 根据tid查询对应book
     * @param tid
     * @return
     */
    List<Book> selectBookByTid(Integer tid);

    /**
     * 搜索
     * @return
     */
    List<Book> search(String data);

    //根据bid查询书的所有信息
    Book selectBookByBid(Integer uid);

    /**
     * 共多少本书
     */
    int selectCount();
}
