package com.hyb.service;

import com.hyb.entity.History;

import java.util.List;

public interface HistoryService {

    List<History> selectMyLendRecord(Integer uid);

    List<History> selectMyBorrowRecord(Integer uid);

    void deleteHistoryByBid(Integer bid);
}
