package com.fbs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    SYS_EXCEPTION(CodeEnum.EXCEPTION.getCode(),"系统异常"),
    SYS_SUCCESS(CodeEnum.SUCCESS.getCode(),"成功"),
    SYS_ERROR(CodeEnum.ERROR.getCode(),"业务逻辑错误"),
    BRAND_SUCCESS(CodeEnum.SUCCESS.getCode(),"品牌新增成功"),
    BRAND_DELETE(CodeEnum.SUCCESS.getCode(),"品牌删除成功"),
    BRAND_DELETE_MORE(CodeEnum.SUCCESS.getCode(),"品牌批量删除成功"),
    SPEC_INSERT_SUCCESS(CodeEnum.SUCCESS.getCode(),"规格添加成功"),
    SPEC_DELETE_MORE_SUCCESS(CodeEnum.SUCCESS.getCode(),"批量删除规格成功"),
    TEMPLATE_ADD_SUCCESS(CodeEnum.SUCCESS.getCode(),"新增模板成功"),
    TRMPLATE_UPDATE_SUCCESS(CodeEnum.SUCCESS.getCode(),"修改模板成功"),
    ITEM_CATE_INSERT_SUCCESS(CodeEnum.SUCCESS.getCode(),"新增分类成功"),
    ITEM_CATE_UPDATE_SUCCESS(CodeEnum.SUCCESS.getCode(),"修改分类成功"),
    ITEM_CATE_DELETE_SUCCESS(CodeEnum.SUCCESS.getCode(),"删除分类成功"),
    ITEM_CATE_IS_EXIST(CodeEnum.ERROR.getCode(),"该分类名称已存在"),
    ITEM_CATE_DELETE(CodeEnum.SUCCESS.getCode(),"分类删除成功")
    ;
    private int code;

    private String msg;

}
