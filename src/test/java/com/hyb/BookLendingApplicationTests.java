package com.hyb;

import com.hyb.entity.Book;
import com.hyb.entity.History;
import com.hyb.mapper.BookMapper;
import com.hyb.mapper.HistoryMapper;
import com.hyb.mapper.UserMapper;
import com.hyb.service.BookService;
import com.hyb.service.HistoryService;
import com.hyb.service.IndexService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class BookLendingApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private HistoryMapper historyMapper;

    @Test
    void contextLoads() {
        for (int i = 0; i < 5; i++) {
            List<Book> randomRecommend = indexService.getRandomRecommend(5);
            for (Book book : randomRecommend) {
                System.out.println(book.getBid()+ ":" + book.getBookName());
            }
            System.out.println("-------------------");
        }
    }

    @Test
    void contextLoads1() {
        for (int i = 1; i < 8; i++) {

            System.out.println(bookMapper.selectTidByBid(i));//可能为null
        }
    }

    @Test
    void contextLoads2() {
        String s  = "1,2,3,4,5,6,7,8,9";
        String[] strings = s.split(",");
        int[] array = Arrays.asList(strings).stream().mapToInt(Integer::parseInt).toArray();
        System.out.println(Arrays.toString(array));
    }

    @Test
    void contextLoads3() {
        List<Book> data = indexService.getDRRecommend(1L, "1,2,3", 10);
        for (Book datum : data) {
            System.out.print(datum.getBid()+" "+datum.getTid() + " | ");
        }
        System.out.println();
    }

    @Test
    void contextLoads4() {
        List<History> histories = historyMapper.selectMyBorrowRecord(2);
        for (History history : histories) {
            System.out.println(history.getStartTime());
        }
        System.out.println(new Date().getTime());
    }

}
