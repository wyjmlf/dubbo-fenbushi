package com.fbs.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_item_cat")

@Data
public class ItemCat implements Serializable {

    private static final long serialVersionUID = -2599148150008976627L;


    @Id
    @KeySql(useGeneratedKeys = true)
    private Long catId;

    private Long parentId;

    private String catName;

    private Boolean hasChildren;

    private Long firstParentId;

    private Integer rank;
}
