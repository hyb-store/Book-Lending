package com.hyb.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/*
 * @ControllerAdvice是在类上声明的注解，其用法主要有三点：
 *      @ExceptionHandler注解标注的方法：用于捕获Controller中抛出的不同类型的异常，从而达到异常全局处理的目的；
 *      @InitBinder注解标注的方法：用于请求中注册自定义参数的解析，从而达到自定义请求参数格式的目的；
 *      @ModelAttribute注解标注的方法：表示此方法会在执行目标Controller方法之前执行
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class) //异常处理
    public void exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("Request Url: {}, exception: {}", request.getRequestURL(), e); //打印访问的url和异常信息
    }
}
