package com.giveandtake.userService.exceptions;

import lombok.Getter;

@Getter
public class TechnicalException extends RuntimeException {

    private final ExceptionPayload payload;

    public TechnicalException(ExceptionPayload payload) {
        this.payload = payload;
    }

}

