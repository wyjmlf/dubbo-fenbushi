package com.fbs;

import com.fbs.req.PageReq;
import lombok.Data;

@Data
public class ItemCatPageVo extends PageReq {

    private Long parentId;
}
