package com.fbs.mapper;

import com.fbs.pojo.Spec;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SpecMapper extends Mapper<Spec>, IdListMapper<Spec,Long> {
}
