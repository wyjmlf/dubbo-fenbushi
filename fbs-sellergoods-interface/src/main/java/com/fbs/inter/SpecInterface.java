package com.fbs.inter;

import com.fbs.pojo.Spec;
import com.fbs.req.IdReq;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;

import java.util.List;

public interface SpecInterface {

    public void insert(Spec spec);

    public PageResult<Spec> pageList(PageReq pageReq);

    public void deleteMore(List<Spec> list);

    public Spec getById(IdReq idReq);


}
