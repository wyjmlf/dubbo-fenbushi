package com.fbs.vo;

import com.fbs.util.CommonUtil;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class TemplateVo implements Serializable {

    private static final long serialVersionUID = -9127823615542262049L;
    private Long tempId;

    @NotBlank(message = "tempName"+ CommonUtil.EMPTY)
    private String tempName;

    @NotNull(message = "brandIdList"+CommonUtil.EMPTY)
    @Size(message = "brandIdList"+CommonUtil.SIZE)
    private List<Long> brandIdList;

    @NotNull(message = "specIdList"+CommonUtil.EMPTY)
    @Size(message = "specIdList"+CommonUtil.SIZE)
    private List<Long> specIdList;

    private List<Map<String,Object>> customAttributeList;
}
