package com.fbs.inter;

import com.fbs.pojo.SpecOption;

import java.util.List;

public interface SpecOptionInterface {

    public void inseretList(List<SpecOption> list,Long specId);

    public void deleteMore(List<Long> specId);

    public void deleteMoreById(List<Long> specOptionId);

    public List<SpecOption> getBySpenId(Long specId);

}
