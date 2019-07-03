package com.fbs.vo.shoop;

import com.fbs.pojo.Spec;
import com.fbs.pojo.SpecOption;
import com.fbs.util.CommonUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class SpecReq  {

    @NotBlank(message = "specName"+ CommonUtil.EMPTY)
    private String specName;

    @NotNull(message = "list"+CommonUtil.EMPTY)
    @Size(min = 1,message = "list"+CommonUtil.SIZE)
    List<SpecOption> list;

    Long specId;
}
