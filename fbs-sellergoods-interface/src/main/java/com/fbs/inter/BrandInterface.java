package com.fbs.inter;

import com.fbs.pojo.Brand;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;

import java.util.List;

public interface BrandInterface {

    public PageResult<Brand> brandPageList(PageReq pageReq);

    public void insertOrUpdate(Brand brand);

    public void deleteMore(List<Brand> list);


}
