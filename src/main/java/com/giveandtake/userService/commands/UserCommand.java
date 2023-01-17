package com.giveandtake.userService.commands;


import com.giveandtake.userService.entities.Gender;
import com.giveandtake.userService.utilities.Assert;
import com.giveandtake.userService.utilities.Validatable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.giveandtake.userService.constants.RegexConstant.EMAIL;
import static com.giveandtake.userService.constants.RegexConstant.PHONE;


@Getter
@Setter
@NoArgsConstructor
public class UserCommand implements Validatable {

    private String userName;

    private String email;

    private String password;

    private Gender gender;

    private String phone;

    private String address;


    @Override
    public void validate() {
        System.out.println(email);
        Assert.assertNotEmpty(userName);
        Assert.assertNotEmpty(password);
        Assert.assertRegex(email, EMAIL);
        Assert.assertRegex(phone, PHONE);
    }
}