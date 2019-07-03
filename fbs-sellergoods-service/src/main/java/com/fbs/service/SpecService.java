package com.fbs.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fbs.inter.SpecInterface;
import com.fbs.inter.SpecOptionInterface;
import com.fbs.mapper.SpecMapper;
import com.fbs.pojo.Spec;
import com.fbs.pojo.SpecOption;
import com.fbs.req.IdReq;
import com.fbs.req.PageReq;
import com.fbs.res.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecService implements SpecInterface {

    @Resource
    SpecMapper specMapper;

    @Resource
    SpecOptionInterface specOptionInterface;

    /**
     * 增加和修改在一起做用id区分
     */
    @Override
    @Transactional

    public void insert(Spec spec) {
        if (spec.getSpecId()==null){
            specMapper.insert(spec);
            specOptionInterface.inseretList(spec.getList(),spec.getSpecId());
        }else {
            specMapper.updateByPrimaryKeySelective(spec);
            specOptionInterface.deleteMore(Arrays.asList(spec.getSpecId()));
            specOptionInterface.inseretList(spec.getList(),spec.getSpecId());
        }

    }

    @Override
    public PageResult<Spec> pageList(PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(),pageReq.getPageSize());
        List<Spec> specs = specMapper.selectAll();
        PageInfo<Spec> pageInfo=new PageInfo<>(specs);
        return PageResult.createPageResult(pageInfo.getTotal(),specs);
    }

    @Override
    @Transactional
    public void deleteMore(List<Spec> list) {
        List<Long> collect = list.stream().map(Spec::getSpecId).collect(Collectors.toList());
        specMapper.deleteByIdList(collect);
        specOptionInterface.deleteMore(collect);

    }

    @Override
    public Spec getById(IdReq idReq) {
        Spec spec = specMapper.selectByPrimaryKey(idReq.getId());
        List<SpecOption> bySpenId = specOptionInterface.getBySpenId(idReq.getId());
        spec.setList(bySpenId);
        return spec;
    }
}
