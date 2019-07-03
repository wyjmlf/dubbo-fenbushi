package com.fbs.ctrl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fbs.ExcaptionUril.ValidateException;
import com.fbs.enums.ExceptionEnum;
import com.fbs.inter.BrandInterface;
import com.fbs.pojo.Brand;
import com.fbs.req.IdReq;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;
import com.fbs.res.Result;
import com.fbs.vo.brand.InsertBrand;
import com.github.pagehelper.PageInfo;
import javafx.scene.chart.ValueAxis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@Slf4j
public class BrandCtrl {

    @Reference(check = false)
    BrandInterface brandInterface;

    @RequestMapping(value = "/pageList")
    public ResponseEntity<Result> pageList(@RequestBody @Valid PageReq pageReq,BindingResult result){

        if (result.hasErrors()){
            throw new ValidateException(result.getFieldErrors());
        }

        return ResponseEntity.status(HttpStatus.OK).body( brandInterface.brandPageList(pageReq));
    }

    @RequestMapping(value = "/insert")
    public ResponseEntity<Result> insert(@RequestBody @Valid InsertBrand insertBrand, BindingResult result){
        if (result.hasErrors()){
            throw new ValidateException(result.getFieldErrors());
        }
        Brand brand=new Brand();
        BeanUtils.copyProperties(insertBrand,brand);
        brandInterface.insertOrUpdate(brand);
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildExceptionEnum(ExceptionEnum.BRAND_SUCCESS,true));
    }

    /**
     * 修改和删除品牌
     */
    @RequestMapping(value = "/delete")
    public ResponseEntity<Result> deleteOrUpdate(@RequestBody @Valid IdReq idReq,BindingResult result){
        if (result.hasErrors()){
            throw new ValidateException(result.getFieldErrors());
        }
        Brand brand=new Brand();
        BeanUtils.copyProperties(idReq,brand);
        brand.setHaDelete(true);
        brandInterface.insertOrUpdate(brand);
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildExceptionEnum(ExceptionEnum.BRAND_DELETE,true));
    }

    /**
     * 批量修改删除的状态
     */
    @RequestMapping(value = "/deleteMore")
    public ResponseEntity<Result> deleteMore(@RequestBody List<Brand> list){
        brandInterface.deleteMore(list);
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildExceptionEnum(ExceptionEnum.BRAND_DELETE_MORE,true));
    }
}
