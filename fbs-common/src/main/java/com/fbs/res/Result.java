package com.fbs.res;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fbs.enums.ExceptionEnum;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final long serialVersionUID = -8132745618471337313L;

    private Integer success;

    private String msg;

    private Object data;

    private Boolean flg;

    public static Result build(Integer success, String msg, Object data,boolean flg) {
        return new Result(success, msg, data,flg);
    }



    public static Result ok(Object data) {
        return new Result(data);
    }



    public Result(String data) {
        this.data=data;
        this.msg="成功";
        this.success=200;
    }

    public Result( ) {
        this.data="";
        this.msg="成功";
        this.success=200;
    }

    public Result(ExceptionEnum em){
        this.success=em.getCode();
        this.msg=em.getMsg();
        this.data="失败";
    }



    public static Result buildExceptionEnum(ExceptionEnum exceptionEnum,boolean flg){
        ExceptionEnum success = ExceptionEnum.SYS_SUCCESS;
        return Result.build(success.getCode(),exceptionEnum.getMsg(),flg);
    }

    public static Result buildSuccessDateNotEnum(Object data,boolean flg){
        ExceptionEnum success = ExceptionEnum.SYS_SUCCESS;
        return Result.build(success.getCode(),success.getMsg(),data,false);
    }



    public static Result build(Integer success, String msg,boolean flg) {
        return new Result(success, msg, null,flg);
    }

    public Result(Integer success, String msg, Object data,boolean flg) {
        this.success = success;
        this.msg = msg;
        this.data = data;
        this.flg=flg;
    }

    public Result(Object data) {
        this.success = 200;
        this.msg = "OK";
        this.data = data;
    }

//    public Integer isOK() {
//        return this.success == 200;
//    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public void setFlg(Boolean flg) {
        this.flg = flg;
    }

    public Integer getSuccess() {
        return success;
    }

    public Boolean getFlg() {
        return flg;
    }

    /**
     * ��json�����ת��ΪTaotaoResult����
     *
     * @param jsonData json����
     * @param clazz TaotaoResult�е�object����
     * @return
     */
    public static Result formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("success").intValue(), jsonNode.get("msg").asText(), obj,false);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * û��object�����ת��
     *
     * @param json
     * @return
     */
    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object�Ǽ���ת��
     *
     * @param jsonData json����
     * @param clazz �����е�����
     * @return
     */
    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("success").intValue(), jsonNode.get("msg").asText(), obj,false);
        } catch (Exception e) {
            return null;
        }
    }

}
