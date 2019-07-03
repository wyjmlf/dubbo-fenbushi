package com.fbs.inter;

import com.fbs.pojo.Template;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;
import com.fbs.vo.TemplateVo;

public interface TemplateInterface {

    public void insert(TemplateVo templateVo);

    public PageResult<Template> pageList(PageReq pageReq);
}
