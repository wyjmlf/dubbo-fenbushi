package com.fbs.res;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class PageResult<T> extends Result implements Serializable {

    private static final long serialVersionUID = -8127859373754780672L;
    private Long total;


    public PageResult() {
    }

    public PageResult(Integer code, String msg, Object data, Long total ) {
        super(code, msg, data,false);
        this.total = total;

    }



    public static PageResult createPageResult(Long total, List rows){
       return new PageResult(200,"成功",rows,total);
    }
}
