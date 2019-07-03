package com.fbs.ctrl;

import com.fbs.ExcaptionUril.ValidateException;
import com.fbs.res.Result;
import com.fbs.vo.itemCat.ItemCatVo;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/itemCat")
public class ItemCatCtrl {

    @RequestMapping(value = "insert")
    public ResponseEntity<Result> insert(@RequestBody @Valid ItemCatVo itemCatVo, BindingResult result){
        if (result.hasErrors()){
            throw  new ValidateException(result.getFieldErrors());
        }

        System.out.println(itemCatVo);
        return null;
    }
}
