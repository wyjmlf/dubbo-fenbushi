package com.fbs.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fbs.inter.SpecOptionInterface;
import com.fbs.mapper.SpecOptionMapper;
import com.fbs.pojo.Spec;
import com.fbs.pojo.SpecOption;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class SpecOptionService implements SpecOptionInterface {

    @Resource
    SpecOptionMapper specOptionMapper;
    @Override

    public void inseretList(List<SpecOption> list,Long specId) {

        specOptionMapper.insertSpecOptionList(list,specId);
    }

    @Override
    public void deleteMore(List<Long> specId) {
        Example example=new Example(SpecOption.class);
        example.createCriteria().andIn("specId",specId);
        specOptionMapper.deleteByExample(example);
    }

    @Override
    public void deleteMoreById(List<Long> specOptionId) {
        specOptionMapper.deleteByIdList(specOptionId);
    }

    @Override
    public List<SpecOption> getBySpenId(Long specId) {
        Example example=new Example(SpecOption.class);
        example.createCriteria().andIn("specId", Arrays.asList(specId));
        return specOptionMapper.selectByExample(example);
    }
}
