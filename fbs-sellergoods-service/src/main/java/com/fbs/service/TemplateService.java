package com.fbs.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;
import com.fbs.inter.TemplateInterface;
import com.fbs.mapper.BrandMpper;
import com.fbs.mapper.SpecMapper;
import com.fbs.mapper.TemplateMapper;
import com.fbs.pojo.Brand;
import com.fbs.pojo.Spec;
import com.fbs.pojo.Template;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;
import com.fbs.res.Result;
import com.fbs.vo.TemplateVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TemplateService implements TemplateInterface {

    @Resource
    BrandMpper brandMpper;

    @Resource
    SpecMapper specMapper;

    @Resource
    TemplateMapper templateMapper;

    @Override
    public void insert(TemplateVo templateVo) {
        Template template=new Template();
        template.setTempName(templateVo.getTempName());
        template.setTempId(templateVo.getTempId());
        //获取品牌几何
        List<Brand> brands = brandMpper.selectByIdList(templateVo.getBrandIdList());
        template.setBrandIds(JSONObject.toJSONString(brands));
        template.setCustomAttributeItems(JSONObject.toJSONString(templateVo.getCustomAttributeList()));
        //获取规格
        List<Spec> specs = specMapper.selectByIdList(templateVo.getSpecIdList());
        template.setSpecIds(JSONObject.toJSONString(specs));
        if(template.getTempId()==null){
            templateMapper.insertSelective(template);
        }else {
            templateMapper.updateByPrimaryKeySelective(template);
        }

    }

    @Override
    public PageResult<Template> pageList(PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(),pageReq.getPageSize());
        List<Template> templates = templateMapper.selectAll();
        PageInfo<Template> pageInfo=new PageInfo<>(templates);

        return PageResult.createPageResult(pageInfo.getTotal(),templates);
    }
}
