package com.hyb.service.impl;

import com.hyb.entity.Book;
import com.hyb.entity.History;
import com.hyb.entity.User;
import com.hyb.mapper.BookMapper;
import com.hyb.mapper.BorrowMapper;
import com.hyb.mapper.HistoryMapper;
import com.hyb.mapper.UserMapper;
import com.hyb.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Value("${file.save-path}")
    private String savePath;

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insertNewBook(MultipartFile file, Book book) {
        //获取要上传文件的名称
        String fileName = file.getOriginalFilename();

        //获取到后缀名
        String suffixName = fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".")) : null;
        //文件的保存重新按照时间戳命名
        String newName = System.currentTimeMillis() + suffixName;
        File newFile = new File(savePath, newName);

        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        try {
            //文件写入
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        book.setStatus(0);
        book.setCount(0);
        //将这些文件的信息写入到数据库中
        System.out.println(book);
        borrowMapper.insertNewBook(book, newName);

        userMapper.updateScoresByUid(book.getUid(), 1);//上传图书+1分
    }

    @Override //借出
    public User borrowBook(History history) {
        //更新book的status和count
        bookMapper.updateStatusByBid(history.getBid(), 1);//未借出-》中间态
        bookMapper.increaseCount(history.getBid());//count++
        //添加history，设置开始时间
        history.setStartTime(new Date());
        historyMapper.insertNewRecord(history);
        //返回书主人信息
        User user = userMapper.selectUserById(history.getlUid());
        return user;

    }
    @Override //确定借出成功
    public void borrowBookOK(Integer bid) {
        //更新book的status和count
        bookMapper.updateStatusByBid(bid, 2);//中间态-》已借出
    }

//    @Override//还书
//    public void returnBook(Integer hid) {
//        //根据hid查出history
//        History history = historyMapper.selectHistoryByHid(hid);
//        //更新history,是否准时
//        Date realDate = new Date();
//        history.setRealTime(realDate);
//        if (history.getEndTime().compareTo(realDate) >= 0) {//没有超时
//            history.setPunctuality(0);
//            //更新user积分
//            userMapper.updateScoresByUid(history.getbUid(), 1);//准时+1分
//        } else {//超时
//            history.setPunctuality(1);
//            //更新user积分
//            userMapper.updateScoresByUid(history.getbUid(), -3);//不准时-3分
//        }
//        historyMapper.updateRecord(history);
//        //更新book的status
//        bookMapper.updateStatusByBid(history.getBid(), 1);//已借出->中间态
//    }
//
//    @Override//确定还书成功
//    public void returnBookOK(Integer bid) {
//        //更新book的status
//        bookMapper.updateStatusByBid(bid, 0);//中间态->未借出
//    }

    @Override//确定还书成功
    public void returnBookOK(Integer hid) {
        //根据hid查出history
        History history = historyMapper.selectHistoryByHid(hid);
        //更新history,是否准时
        Date realDate = new Date();
        history.setRealTime(realDate);
        if (history.getEndTime().compareTo(realDate) >= 0) {//没有超时
            history.setPunctuality(0);
            //更新user积分
            userMapper.updateScoresByUid(history.getbUid(), 1);//准时+1分
        } else {//超时
            history.setPunctuality(1);
            //更新user积分
            userMapper.updateScoresByUid(history.getbUid(), -3);//不准时-3分
        }
        historyMapper.updateRecord(history);
        //更新book的status
        bookMapper.updateStatusByBid(history.getBid(), 2);//已借出->中间态
    }
}