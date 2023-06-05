package com.erato.cloud.common.dto;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Result<T> {

    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private T data;

    public static Result success() {
        return new Result().setCode(200).setMessage("success");
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>().setCode(200).setMessage("success").setData(data);
    }

    public static <T> Result<T> fail(int code, String message) {
        return new Result<T>().setCode(code).setMessage(message);
    }
}
