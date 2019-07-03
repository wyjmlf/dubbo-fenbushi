package com.fbs.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "tb_spec_option")
@Data
public class SpecOption implements Serializable {

    private static final long serialVersionUID = 2626714783449527738L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long optionId;

    private String optionName;

    private Long specId;

    private Integer orders;


}
