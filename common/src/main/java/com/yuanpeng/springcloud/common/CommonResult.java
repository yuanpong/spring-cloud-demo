package com.yuanpeng.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    public int code;
    public String message;
    public T data;



    public static <T> CommonResult<T> Success(T data) {
        return new CommonResult<>(200,"success",data);
    }
    public static <T> CommonResult<T> Success() {
        return new CommonResult<>(200,"success",null);
    }

    public static <T> CommonResult<T> error(String message) {
        return new CommonResult<>(400,message,null);
    }

}
