package com.fbs.vo.brand;

import com.fbs.enums.CodeEnum;
import com.fbs.util.CommonUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@Data
public class InsertBrand {

    private static final int chart=1;

    @NotBlank(message = "brandName"+ CommonUtil.EMPTY)
    private String brandName;

    @NotBlank(message = "firstChart"+CommonUtil.EMPTY)
    @Length(max = chart,message = "firstChart的长度是："+chart)
    private String firstChart;
}
