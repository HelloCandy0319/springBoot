package com.example.demo.result;

import lombok.Data;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@Data
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -6498197804868465231L;

    private static final String successCode = "200";

    private T data;

    private String code;

    private String msg;

    public Response() {
        this.code = successCode;
        this.msg = "请求成功";
    }

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Response(T data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Response(T data) {
        this.data = data;
    }
}
