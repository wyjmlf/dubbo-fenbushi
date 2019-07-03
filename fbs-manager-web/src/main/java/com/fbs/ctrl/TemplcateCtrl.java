package com.fbs.ctrl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fbs.ExcaptionUril.ValidateException;
import com.fbs.enums.ExceptionEnum;
import com.fbs.inter.TemplateInterface;
import com.fbs.req.PageReq;
import com.fbs.res.Result;
import com.fbs.vo.TemplateVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/temp")
public class TemplcateCtrl {

    @Reference
    TemplateInterface templateInterface;

    @RequestMapping(value = "/insert")
    public ResponseEntity<Result> insert(@RequestBody @Valid TemplateVo templateVo, BindingResult result){
        if (result.hasErrors()){
            throw new ValidateException(result.getFieldErrors());
        }
        templateInterface.insert(templateVo);
        ExceptionEnum templateAddSuccess = templateVo.getTempId()==null?ExceptionEnum.TEMPLATE_ADD_SUCCESS:ExceptionEnum.TRMPLATE_UPDATE_SUCCESS;
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildExceptionEnum(templateAddSuccess,true));
    }

    @RequestMapping(value = "/pageList")
    public ResponseEntity<Result> pageList(@RequestBody @Valid PageReq pageReq,BindingResult result){
        if (result.hasErrors()){
            throw new ValidateException(result.getFieldErrors());
        }
        return ResponseEntity.status(HttpStatus.OK).body(templateInterface.pageList(pageReq));
    }
}
