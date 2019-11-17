package com.webhope.emergency.enums;


import lombok.Getter;

/**
 * 返回码枚举类
 * @author w.z
 * @date 2019/11/17 20:54
 */
@Getter
public enum ErrorCodeEnum {

    SUCCESS("0000","请求成功"),
    DATA_ERROR("0100","数据错误");
    /**
     * 提示码
     */
    private String code;

    /**
     * 提示内容
     */
    private String msg;

    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
