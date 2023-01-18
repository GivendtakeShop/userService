package com.giveandtake.userService.dtos;


import com.giveandtake.userService.entities.Gender;
import com.giveandtake.userService.entities.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

    private String id;
    private String email;
    private String userName;
    private Gender gender;
    private String phone;
    private String address;
    private Role role;
}
