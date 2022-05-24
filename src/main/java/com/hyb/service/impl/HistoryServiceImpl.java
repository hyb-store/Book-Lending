package com.hyb.service.impl;

import com.hyb.entity.History;
import com.hyb.mapper.HistoryMapper;
import com.hyb.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override//借出
    public List<History> selectMyLendRecord(Integer uid) {
        return historyMapper.selectMyLendRecord(uid);
    }

    @Override//借入
    public List<History> selectMyBorrowRecord(Integer uid) {
        return historyMapper.selectMyBorrowRecord(uid);
    }

    @Override//删除历史记录
    public void deleteHistoryByBid(Integer bid) {
        historyMapper.deleteHistoryByBid(bid);
    }


}
