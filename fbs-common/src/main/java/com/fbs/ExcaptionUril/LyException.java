package com.fbs.ExcaptionUril;


import com.fbs.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//因为有lombok。所以可以用注解来生成get set 构造
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

    /*public LyException(ExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

    public LyException(String message, ExceptionEnum exceptionEnum) {
        super(message);
        this.exceptionEnum = exceptionEnum;
    }

    public LyException(String message, Throwable cause, ExceptionEnum exceptionEnum) {
        super(message, cause);
        this.exceptionEnum = exceptionEnum;
    }

    public LyException(Throwable cause, ExceptionEnum exceptionEnum) {
        super(cause);
        this.exceptionEnum = exceptionEnum;
    }

    public LyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ExceptionEnum exceptionEnum) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exceptionEnum = exceptionEnum;
    }

    public LyException() {
    }

    public ExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }*/
}
