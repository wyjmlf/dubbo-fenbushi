package com.fbs.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fbs.inter.ItemCatInterface;
import com.fbs.mapper.ItemCatMapper;
import com.fbs.pojo.ItemCat;

import javax.annotation.Resource;

@Service
public class ItemCatService implements ItemCatInterface {

    @Resource
    ItemCatMapper itemCatMapper;

    @Override
    public void insertOrUpdate(ItemCat itemCat) {
        if (itemCat.getCatId()==null){
            itemCatMapper.insertSelective(itemCat);
        }else {
            itemCatMapper.updateByPrimaryKeySelective(itemCat);
        }
    }
}
