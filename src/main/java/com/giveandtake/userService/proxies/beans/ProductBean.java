package com.giveandtake.userService.proxies.beans;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductBean {

    private String id;
    private String name;
    private long price;
    private ProductType type;
    private String description;
    private int quantity;
    private String coverId;

}
