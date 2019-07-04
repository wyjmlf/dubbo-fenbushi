package com.fbs.ctrl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fbs.ExcaptionUril.ValidateException;
import com.fbs.enums.ExceptionEnum;
import com.fbs.inter.ItemCatInterface;
import com.fbs.pojo.ItemCat;
import com.fbs.res.Result;
import com.fbs.vo.itemCat.ItemCatVo;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/itemCat")
public class ItemCatCtrl {

    @Reference
    ItemCatInterface itemCatInterface;

    @RequestMapping(value = "insert")
    public ResponseEntity<Result> insert(@RequestBody @Valid ItemCatVo itemCatVo, BindingResult result){
        if (result.hasErrors()){
            throw  new ValidateException(result.getFieldErrors());
        }
        ItemCat itemCat=new ItemCat();
        BeanUtils.copyProperties(itemCatVo,itemCat);
        itemCatInterface.insertOrUpdate(itemCat);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Result.buildExceptionEnum(itemCatVo.getCatId()==null?
                        ExceptionEnum.ITEM_CATE_INSERT_SUCCESS:ExceptionEnum.ITEM_CATE_UPDATE_SUCCESS,true));
    }
}
