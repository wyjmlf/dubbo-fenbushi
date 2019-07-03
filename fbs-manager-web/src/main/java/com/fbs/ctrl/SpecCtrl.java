package com.fbs.ctrl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fbs.ExcaptionUril.ValidateException;
import com.fbs.enums.ExceptionEnum;
import com.fbs.inter.SpecInterface;
import com.fbs.pojo.Spec;
import com.fbs.req.IdReq;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;
import com.fbs.res.Result;
import com.fbs.vo.shoop.SpecReq;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/spec")
public class SpecCtrl {

    @Reference
    SpecInterface specInterface;

    @RequestMapping(value = "/insert")
    public ResponseEntity<Result> insert(@RequestBody @Valid SpecReq specReq, BindingResult result){
        if (result.hasErrors()){
            throw new ValidateException(result.getFieldErrors());
        }
        Spec spec=new Spec();
        BeanUtils.copyProperties(specReq,spec);
        specInterface.insert(spec);
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildExceptionEnum(ExceptionEnum.SPEC_INSERT_SUCCESS,true));
    }

    @RequestMapping(value = "/pageList")
    public ResponseEntity<Result> pageList(@RequestBody @Valid PageReq pageReq,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidateException(bindingResult.getFieldErrors());
        }

        return ResponseEntity.status(HttpStatus.OK).body(specInterface.pageList(pageReq));
    }

    @RequestMapping(value = "/deleteMore")
    public ResponseEntity<Result> deleteMore(@RequestBody List<Spec> list){
        specInterface.deleteMore(list);
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildExceptionEnum(ExceptionEnum.SPEC_DELETE_MORE_SUCCESS,true));
    }

    @RequestMapping(value = "/getSpcById")
    public ResponseEntity<Result> getSpecById(@RequestBody @Valid IdReq idReq,BindingResult result){
        if (result.hasErrors()){
            throw new ValidateException(result.getFieldErrors());
        }
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildSuccessDateNotEnum(specInterface.getById(idReq),false));
    }
}
