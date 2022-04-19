package com.hyb.service.impl;

import com.hyb.entity.Book;
import com.hyb.mapper.BorrowMapper;
import com.hyb.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Value("${file.save-path}")
    private String savePath;

    @Autowired
    private BorrowMapper borrowMapper;

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

        book.setBookImg(newName);
        book.setStatus(0);
        book.setCount(0);
        //将这些文件的信息写入到数据库中
        System.out.println(book);
        //borrowMapper.insertNewBook(book);
    }
}