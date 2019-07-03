package com.fbs.vo.itemCat;


import com.fbs.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.util.pattern.PathPattern;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ItemCatVo {


    private Long parentId=0L;

    @NotBlank(message = "catName"+ CommonUtil.EMPTY)
    @Length(max = 10,message = "catName"+CommonUtil.LENGTH_RANGE+"1-10 之间")
    private String catName;


}
