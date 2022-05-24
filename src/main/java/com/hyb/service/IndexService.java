package com.hyb.service;

import com.hyb.entity.Book;

import java.util.List;

public interface IndexService {
    /**
     * 搜索
     * @return
     */
    List<Book> search(String data);

    /**
     *
     * @return
     */
    List<Book> getTop3();

    List<Book> getRecommend(Long uid, int howMany);

    List<Book> getRandomRecommend(int howMany);

    List<Book> getDRRecommend(Long uid, String data, int howMany);


}
