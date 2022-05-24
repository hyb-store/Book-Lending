package com.hyb.mapper;

import com.hyb.entity.History;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HistoryMapper {

    List<History> selectMyLendRecord(Integer uid);

    List<History> selectMyBorrowRecord(Integer uid);

    History selectHistoryByHid(Integer hid);

    void insertNewRecord(History history);

    void updateRecord(History history);

    void deleteHistoryByBid(Integer bid);
}
