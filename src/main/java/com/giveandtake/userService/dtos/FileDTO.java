package com.giveandtake.userService.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class FileDTO {

    private String name;
    private byte[] data;
    private String type;
}
