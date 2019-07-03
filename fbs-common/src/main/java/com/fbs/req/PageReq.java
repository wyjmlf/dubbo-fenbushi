package com.fbs.req;


import com.fbs.util.CommonUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author win 10
 */
@Data
public class PageReq implements Serializable {

    private static final long serialVersionUID = -1059697689048026500L;

    @NotNull(message ="pageNum"+ CommonUtil.EMPTY)
    private Integer pageNum;

    @NotNull(message ="pageSize"+ CommonUtil.EMPTY)
    private Integer pageSize;
}
