package com.giveandtake.userService.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final ExceptionPayload payload;

    public BusinessException(ExceptionPayload payload) {
        this.payload = payload;
    }

}

