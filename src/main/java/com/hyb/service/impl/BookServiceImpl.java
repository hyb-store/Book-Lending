package com.hyb.service.impl;

import com.hyb.entity.Book;
import com.hyb.entity.Comment;
import com.hyb.entity.Type;
import com.hyb.entity.User;
import com.hyb.mapper.*;
import com.hyb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private TypeMapper typeMapper;

    public List<Book> selectMyBooks(Integer uid){
        List<Book> books = bookMapper.selectMyBooks(uid);
        return books;
    }

    @Override
    public Book selectDetail(Integer bid) {

        Book book = bookMapper.selectBookByBid(bid);

        User user = userMapper.selectUserById(book.getUid());
        Type type = typeMapper.selectById(book.getTid());
        List<Comment> comments = commentMapper.selectByBid(book.getBid());
        for (Comment comment : comments) {
            User uc = userMapper.selectUserById(comment.getUid());
            comment.setUser(uc);
        }
        book.setUser(user);
        book.setType(type);
        book.setComments(comments);

        return book;
    }

    @Override
    public void insertComment(Comment comment) {
        comment.setCommentTime(new Date());
        commentMapper.insertComment(comment);
    }

    @Override
    public Book selectBookByBid(Integer bid) {
        return bookMapper.selectBookByBid(bid);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteBook(Integer bid) {
        //删除book表中的数据
        bookMapper.deleteBookByBid(bid);
        //删除记录
        historyMapper.deleteHistoryByBid(bid);
    }

    @Override
    public void deleteComment(Integer cid) {
        commentMapper.deleteComment(cid);
    }

}
