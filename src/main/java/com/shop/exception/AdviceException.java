package com.shop.exception;

import com.shop.config.PrintHttpUtils;
import com.shop.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class AdviceException {

    @Autowired
    private PrintHttpUtils printHttpUtils;


    @ExceptionHandler(NullPointerException.class)
    public void nullPointerException(HttpServletResponse response) {
        printHttpUtils.print(response, new Result<>("空指针异常"));
    }

    @ExceptionHandler(BusinessException.class)
    public void businessException(HttpServletResponse response,BusinessException e) {
        printHttpUtils.print(response, new Result(e.getMessage(), e.getCode()));
    }

}
