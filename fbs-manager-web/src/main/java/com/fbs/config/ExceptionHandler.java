package com.fbs.config;


import com.fbs.ExcaptionUril.LyException;
import com.fbs.ExcaptionUril.ValidateException;
import com.fbs.enums.CodeEnum;
import com.fbs.enums.ExceptionEnum;
import com.fbs.res.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.validation.UnexpectedTypeException;

/**
 * @author win 10
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    //LyException
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    private ResponseEntity<Object> handlerExcaption(RuntimeException exception) {
        exception.printStackTrace();

        log.error("异常原因：：：" + exception.getMessage());
        log.error("运行时异常堆栈信息：：：", exception);//打印异常的堆栈信息
        if (exception instanceof LyException) {//自定义异常
            LyException lyException = (LyException) exception;

            return ResponseEntity.status(CodeEnum.SUCCESS.getCode()).body(new Result(lyException.getExceptionEnum()));
        } else if (exception instanceof ValidateException) {//参数校验异常
            ValidateException validateException = (ValidateException) exception;
            return ResponseEntity.status(CodeEnum.SUCCESS.getCode()).body(new Result(CodeEnum.ERROR.getCode(), "参数不全或参数错误", validateException.getMessageArray(),true));
        } else if (exception instanceof UnexpectedTypeException) {
            return ResponseEntity.status(CodeEnum.SUCCESS.getCode()).body(new Result(CodeEnum.ERROR.getCode(), "参数校验注解错误", ExceptionEnum.SYS_ERROR.getMsg(),true));
        }
            return ResponseEntity.status(CodeEnum.SUCCESS.getCode()).body(new Result(CodeEnum.ERROR.getCode(), exception.getMessage(), "系统异常",true));


    }

   /*@org.springframework.web.bind.annotation.ExceptionHandler
   @ResponseBody
    public Map<String,Object> aa(RuntimeException e){
       Map<String,Object> map=new HashMap<>();
       map.put("msg",e.getMessage());
       return map;
   }*/
}
