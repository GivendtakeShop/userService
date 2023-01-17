package com.giveandtake.userService.services;

import com.giveandtake.userService.commands.LoginCommand;
import com.giveandtake.userService.commands.UserCommand;
import com.giveandtake.userService.dtos.LoginDTO;
import com.giveandtake.userService.entities.User;

public interface AuthService {
    User signUp(UserCommand userCommand);

    LoginDTO login(LoginCommand loginCommand);
}
