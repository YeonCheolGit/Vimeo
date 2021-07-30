package com.example.vimeo.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseEnum {

    DEFAULT_SUCCESS(true, 0, "성공했습니다.", 200),
    DEFAULT_FAIL(false, -1, "알 수 없는 오류 입니다.", 500),

    BAD_REQUEST(false, -1, "잘못된 요청 입니다.", 404);


    private final boolean check;
    private final int code;
    private final String msg;
    private final int status;
}
