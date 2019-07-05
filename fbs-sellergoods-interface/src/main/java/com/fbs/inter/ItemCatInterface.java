package com.fbs.inter;

import com.fbs.ItemCatPageVo;
import com.fbs.pojo.ItemCat;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;

import java.util.List;

public interface ItemCatInterface {

    public void insertOrUpdate(ItemCat itemCat);

    public PageResult<ItemCat> pageList(ItemCatPageVo req);

    public List<ItemCat> getItemCat(ItemCat itemCat);

    public void deleteItemCat(List<ItemCat> list);
}
