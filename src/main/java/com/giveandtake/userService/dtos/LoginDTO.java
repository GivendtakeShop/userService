package com.giveandtake.userService.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginDTO {
    private String token;
}
