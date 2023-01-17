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
public class LoginCommand implements Validatable {


    private String email;

    private String password;

    @Override
    public void validate() {
        Assert.assertNotEmpty(password);
        Assert.assertRegex(email, EMAIL);
    }
}