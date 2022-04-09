package com.hyb.controller;

import com.hyb.config.OcrProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
public class FileUploadController {

    @Autowired
    private OcrProperties ocr;

    @RequestMapping
    public String file () {
        return ocr.getAPI_KEY() + ocr.getAPP_ID() + ocr.getSECRET_KEY();
    }
}
