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
import java.io.Serializable;

@Data
public class ItemCatVo implements Serializable {

    private static final long serialVersionUID = -217389235651993520L;
    private Long catId;

    @NotNull(message = "parentId"+CommonUtil.DEFAULT+"0")
    private Long parentId;

    @NotBlank(message = "catName"+ CommonUtil.EMPTY)
    @Length(max = 10,message = "catName"+CommonUtil.LENGTH_RANGE+"1-10 之间")
    private String catName;

    @NotNull(message = "firstParentId"+CommonUtil.DEFAULT+"0")
    private Long firstParentId;

    @NotNull(message = "rank"+CommonUtil.EMPTY)
    private Integer rank;


}
