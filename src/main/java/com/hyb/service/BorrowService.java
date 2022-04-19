package com.hyb.service;

import com.hyb.entity.Book;
import org.springframework.web.multipart.MultipartFile;

public interface BorrowService {

    void insertNewBook(MultipartFile file, Book book);

}
