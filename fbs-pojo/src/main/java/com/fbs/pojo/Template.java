package com.fbs.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_template")
@Data
public class Template implements Serializable {

    private static final long serialVersionUID = 1171726790457784918L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long tempId;

    private String tempName;

    private String specIds;

    private String brandIds;

    private String customAttributeItems;
}
