package com.giveandtake.userService.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {

    // Technical Exception
    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),

    // Business Exception
    INVALID_PAYLOAD(1, HttpStatus.CONFLICT, "invalid.request.payload"),

    USER_NOT_FOUND(2, HttpStatus.NOT_FOUND, "user.not.found"),

    REQUIRED_FIELD(3, HttpStatus.CONFLICT, "required.field"),

    UNKOWN_VALUE(4, HttpStatus.CONFLICT, "unkown.value"),

    MIN_VALUE(5, HttpStatus.CONFLICT, "min.value"),

    SIZE_LIMIT_EXCEEDED(6, HttpStatus.CONFLICT,"size.limit.exceeded"),

    MAX_VALUE(7,HttpStatus.CONFLICT ,"max.value" ),
    EMAIL_ALREADY_USED(8, HttpStatus.CONFLICT, "email.already.used" );

    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
