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
    Book selectBookByBid(Integer bid);

    /**
     * 共多少本书
     */
    int selectCount();

    /**
     * 获取借书最多的3本书
     */
    List<Book> getTop3();

    /**
     * 更新status
     */
    void updateStatusByBid(Integer bid, Integer status);

    /**
     * Count++
     */
    void increaseCount(Integer bid);

    /**
     * 根据bid找tid
     * @return
     */
    int selectTidByBid(Integer bid);

    /**
     * 修改信息
     * @param book
     */
    void updateBook(Book book);

    /**
     * 根据bid删除书
     * @param bid
     */
    void deleteBookByBid(Integer bid);
}
