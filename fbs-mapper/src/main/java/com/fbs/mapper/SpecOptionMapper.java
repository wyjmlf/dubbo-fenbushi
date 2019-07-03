package com.fbs.mapper;

import com.fbs.pojo.SpecOption;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpecOptionMapper extends Mapper<SpecOption>, IdListMapper<SpecOption,Long>, InsertListMapper<SpecOption> {
    public void insertSpecOptionList(@Param("list")List<SpecOption> list,@Param("specId")Long specId);
}
