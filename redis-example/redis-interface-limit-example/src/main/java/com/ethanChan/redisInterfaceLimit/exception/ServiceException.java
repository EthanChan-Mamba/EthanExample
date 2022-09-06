package com.ethanChan.redisInterfaceLimit.exception;

/**
 * @author chen
 * @version 1.0.0
 * @ClassName ServiceException.java
 * @Description TODO
 * @createTime 2022-06-09 13:51
 */
public class ServiceException extends RuntimeException {
    public ServiceException(String message) {
        super(message);
    }
}
