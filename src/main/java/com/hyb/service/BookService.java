package com.hyb.service;

import com.hyb.entity.Book;
import com.hyb.entity.Comment;

import java.util.List;

public interface BookService {

    List<Book> selectMyBooks(Integer uid);

    //根据bid查询书的所有信息
    Book selectDetail(Integer bid);

    void insertComment(Comment comment);

    //根据bid查询书的所有信息
    Book selectBookByBid(Integer bid);

    void updateBook(Book book);

    void deleteBook(Integer bid);

    //删除评论
    void deleteComment(Integer cid);
}
