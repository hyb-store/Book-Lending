package com.hyb.service.impl;

import com.hyb.entity.Book;
import com.hyb.entity.History;
import com.hyb.entity.User;
import com.hyb.mapper.UserMapper;
import com.hyb.service.BookService;
import com.hyb.service.HistoryService;
import com.hyb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private HistoryService historyService;

    @Override
    public User selectUserByOpenId(String openId) {
        return userMapper.selectUserByOpenId(openId);
    }

    @Override
    public void insertUser(User user) {
        user.setScores(0);
        user.setRegisterTime(new Date());
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public Integer idByOpenId(String openid) {
        return userMapper.idByOpenId(openid);
    }

    @Override
    public List<Book> getMyBook(Integer uid) {
        return bookService.selectMyBooks(uid);
    }

    @Override
    public List<History> getMyLendRecord(Integer uid) {
        return historyService.selectMyLendRecord(uid);
    }

    @Override
    public List<History> getMyBorrowRecord(Integer uid) {
        return historyService.selectMyBorrowRecord(uid);
    }

}
