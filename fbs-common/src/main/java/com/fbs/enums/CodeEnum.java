package com.fbs.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author win 10
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CodeEnum {


    /**
     * 成功
     */
    SUCCESS(200),


    /**
     * 业务错误
     */
    ERROR(300),


    /**
     * 系统异常
     */
    EXCEPTION(500)
    ;

    private int code;
}
