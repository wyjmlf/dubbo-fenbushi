package com.fbs.mapper;

import com.fbs.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandMpper extends Mapper<Brand>, IdListMapper<Brand,Long> {

    public void deleteMore( @Param("list") List<Brand> list);
}
