package com.fbs.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fbs.ItemCatPageVo;
import com.fbs.inter.ItemCatInterface;
import com.fbs.mapper.ItemCatMapper;
import com.fbs.pojo.ItemCat;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemCatService implements ItemCatInterface {

    @Resource
    ItemCatMapper itemCatMapper;

    @Override

    @Transactional
    public void insertOrUpdate(ItemCat itemCat) {
        if (itemCat.getCatId()==null){
            itemCatMapper.insertSelective(itemCat);
            if (itemCat.getParentId()!=0){
                ItemCat cat=new ItemCat();
                cat.setCatId(itemCat.getParentId());
                cat.setHasChildren(true);
                itemCatMapper.updateByPrimaryKeySelective(cat);
            }
        }else {
            itemCatMapper.updateByPrimaryKeySelective(itemCat);
        }
    }

    @Override
    public PageResult<ItemCat> pageList(ItemCatPageVo req) {
        PageHelper.startPage(req.getPageNum(),req.getPageSize());
        ItemCat itemCat=new ItemCat();
        itemCat.setParentId(req.getParentId());
        List<ItemCat> itemCats = itemCatMapper.select(itemCat);
        PageInfo<ItemCat> pageInfo=new PageInfo<>(itemCats);
        return PageResult.createPageResult(pageInfo.getTotal(),itemCats);
    }

    @Override
    public List<ItemCat> getItemCat(ItemCat itemCat) {
        return itemCatMapper.select(itemCat);
    }

    @Override
    public void deleteItemCat(List<ItemCat> list) {
        Example example=new Example(ItemCat.class);
        example.setDistinct(true);
        List<Long> collect = list.stream().map(ItemCat::getCatId).collect(Collectors.toList());
        example.createCriteria().andIn("catId",collect);

        List<ItemCat> itemCats = itemCatMapper.selectByExample(example);
        itemCatMapper.deleteByPrimaryKey(itemCats.stream().map(ItemCat::getCatId).collect(Collectors.toList()));
    }
}
