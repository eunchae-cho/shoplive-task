package com.shoplive.task.common.response;

import com.shoplive.task.common.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private int code;
    private T data;
    private String message;

    public static <T> ApiResponse<T> ok() {
        return (ApiResponse<T>) new ApiResponse<>(ErrorCode.OK.getKey(), "", ErrorCode.OK.getValue());
    }

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(ErrorCode.OK.getKey(), data, ErrorCode.OK.getValue());
    }

    public static <T> ApiResponse<T> of(int code, String message) {
        return (ApiResponse<T>) new ApiResponse<>(code, "", message);
    }

}
