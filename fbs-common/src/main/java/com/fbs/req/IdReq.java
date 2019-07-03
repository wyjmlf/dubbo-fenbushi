package com.fbs.req;

import com.fbs.util.CommonUtil;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class IdReq implements Serializable {

    private static final long serialVersionUID = -4660821397521499738L;
    @NotNull(message = "id"+ CommonUtil.EMPTY)
    private Long id;
}
