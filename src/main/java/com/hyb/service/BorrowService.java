package com.hyb.service;

import com.hyb.entity.Book;
import com.hyb.entity.History;
import com.hyb.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface BorrowService {

    void insertNewBook(MultipartFile file, Book book);

    User borrowBook(History history);

    void borrowBookOK(Integer bid);

    //void returnBook(Integer hid);

    //void returnBookOK(Integer bid);

    void returnBookOK(Integer hid);

}
