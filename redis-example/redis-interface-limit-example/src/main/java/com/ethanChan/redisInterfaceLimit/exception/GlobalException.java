package com.ethanChan.redisInterfaceLimit.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName GlobalException.java
 * @Description TODO
 * @createTime 2022-06-09 13:57
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(ServiceException.class)
    public Map<String,Object> serviceException(ServiceException e) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("status", 500);
        map.put("message", e.getMessage());
        return map;
    }
}
