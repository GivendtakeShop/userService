package com.giveandtake.userService.proxies.beans;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoverBean {
    private String name;
    private byte[] data;
    private String type;
    private long size;
}
