package com.fbs.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fbs.inter.BrandInterface;
import com.fbs.mapper.BrandMpper;
import com.fbs.pojo.Brand;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BrandService implements BrandInterface {

    @Resource
    BrandMpper brandMpper;

    @Override
    public PageResult<Brand> brandPageList(PageReq pageReq) {
        log.info("从本机获取>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        PageHelper.startPage(pageReq.getPageNum(),pageReq.getPageSize());
        Brand brand=new Brand();
        brand.setHaDelete(false);
        List<Brand> list = brandMpper.select(brand);
        PageInfo<Brand> pageInfo=new PageInfo<>(list);
        return PageResult.createPageResult(pageInfo.getTotal(),list);
    }

    @Override
    public void insertOrUpdate(Brand brand) {
        if (brand.getId()==null){
            brandMpper.insertSelective(brand);
        }else {
            brandMpper.updateByPrimaryKeySelective(brand);
        }
    }

    @Override
    public void deleteMore(List<Brand> list) {
           brandMpper.deleteMore(list);
    }
}
