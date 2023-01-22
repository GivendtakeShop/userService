package com.giveandtake.userService.commands;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileCommand {

    private String name;

    private String type;

    private byte[] data;


}
