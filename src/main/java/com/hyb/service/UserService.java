package com.hyb.service;

import com.hyb.entity.Book;
import com.hyb.entity.History;
import com.hyb.entity.User;

import java.util.List;

public interface UserService {

    public User selectUserByOpenId(String openId);

    public void insertUser(User user);

    public void updateUser(User user);

    public Integer idByOpenId(String openid);

    public List<Book> getMyBook(Integer uid);

    public List<History> getMyLendRecord(Integer uid);

    public List<History> getMyBorrowRecord(Integer uid);

}
