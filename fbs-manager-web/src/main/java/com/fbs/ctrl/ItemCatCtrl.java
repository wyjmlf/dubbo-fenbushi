package com.fbs.ctrl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.fbs.ExcaptionUril.LyException;
import com.fbs.ExcaptionUril.ValidateException;
import com.fbs.ItemCatPageVo;
import com.fbs.enums.ExceptionEnum;
import com.fbs.inter.ItemCatInterface;
import com.fbs.pojo.ItemCat;
import com.fbs.req.PageReq;
import com.fbs.res.Result;
import com.fbs.vo.itemCat.ItemCatVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/itemCat")
public class ItemCatCtrl {

    @Reference
    ItemCatInterface itemCatInterface;


    /*@ModelAttribute
    public void modelAttr(ModelMap modelMap, HttpServletRequest request) throws IOException {

        InputStream in = request.getInputStream();
        String s = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
        StringBuffer sb = new StringBuffer();
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        JSONObject jsonObject=JSONObject.parseObject(sb.toString());

    }*/


    @RequestMapping(value = "insert")
    @ResponseBody
    public ResponseEntity<Result> insert(@RequestBody @Valid ItemCatVo itemCatVo, BindingResult result){
        if (result.hasErrors()){
            throw  new ValidateException(result.getFieldErrors());
        }

        ItemCat item=new ItemCat();
        BeanUtils.copyProperties(itemCatVo,item);
        itemCatInterface.insertOrUpdate(item);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Result.buildExceptionEnum(itemCatVo.getCatId()==null?
                        ExceptionEnum.ITEM_CATE_INSERT_SUCCESS:ExceptionEnum.ITEM_CATE_UPDATE_SUCCESS,true));
    }



    @RequestMapping(value = "/pageList")
    @ResponseBody
    public ResponseEntity<Result> pageList(@RequestBody @Valid ItemCatPageVo req, BindingResult result){
        if (result.hasErrors()){
            throw  new ValidateException(result.getFieldErrors());
        }

        return ResponseEntity.status(HttpStatus.OK).body(itemCatInterface.pageList(req));
    }

    @RequestMapping(value = "deleteItemCat")
    @ResponseBody
    public ResponseEntity<Result> deleteItemCat(@RequestBody List<ItemCat> list){
        itemCatInterface.deleteItemCat(list);
        return ResponseEntity.status(HttpStatus.OK).body(Result.buildExceptionEnum(ExceptionEnum.ITEM_CATE_DELETE,true));
    }
}
