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
    List<Book> getTop5();

    List<Book> getRecommend(Long userId, int howMany);
}
