package com.webhope.emergency.exception;

import com.webhope.emergency.enums.ErrorCodeEnum;

/**
 * 业务异常
 * @author w.z
 * @date 2019/11/17 21:03
 */
public class BusinessException extends RuntimeException {

    /**
     * 异常码
     */
    private String code;

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(ErrorCodeEnum errorEnum) {
        super(errorEnum.getMsg());
        this.code = errorEnum.getCode();
    }

    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }
}
