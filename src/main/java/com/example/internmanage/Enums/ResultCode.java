package com.example.internmanage.Enums;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(true,200,"成功"),
    FAILED(false,400,"失败"),
    ERROR(false,500,"未知错误");

    private final Boolean success;

    private final Integer code;

    private final String message;

    ResultCode(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }
}
