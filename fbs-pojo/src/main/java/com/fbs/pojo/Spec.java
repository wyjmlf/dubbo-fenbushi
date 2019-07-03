package com.fbs.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@Table(name = "tb_spec")
@Data
public class Spec implements Serializable {

    private static final long serialVersionUID = -798149653960713754L;
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long specId;

    private String specName;

    @Transient
    List<SpecOption> list;

    @Transient
    private boolean hasChildren=true;
}
