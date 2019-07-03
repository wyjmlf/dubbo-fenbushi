package com.fbs.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tb_brand")
@Data

public class Brand implements Serializable {

    private static final long serialVersionUID = -241675977906280429L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String brandName;

    private String firstChart;

    private Boolean haDelete;
}
