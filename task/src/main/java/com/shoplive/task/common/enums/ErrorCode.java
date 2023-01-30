package com.shoplive.task.common.enums;

import com.shoplive.task.common.enums.EnumModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode implements EnumModel {

    OK(200, "success"),
    BAD_REQUEST(400, "bad request"),
    RESOURCE_NOT_FOUND(404, "resource not found"),
    METHOD_NOT_ALLOWED(405, "method not allowed"),
    INTERNAL_SERVER_ERROR(500, "internal server error"),
    ;
    private int code;
    private String message;

    @Override
    public int getKey() {
        return code;
    }

    @Override
    public String getValue() {
        return message;
    }
}
