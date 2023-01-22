package com.giveandtake.userService.controllers;

import com.giveandtake.userService.commands.LoginCommand;
import com.giveandtake.userService.commands.UserCommand;
import com.giveandtake.userService.dtos.LoginDTO;
import com.giveandtake.userService.dtos.UserDTO;
import com.giveandtake.userService.dtos.mappers.UserMapper;
import com.giveandtake.userService.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.giveandtake.userService.constants.PathConstant.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(V1+AUTH)
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;
    private final UserMapper userMapper;


    @PostMapping(SIGNUP)
    public UserDTO signUp(@RequestBody UserCommand userCommand){
        return  userMapper.userToUserDTO(authService.signUp(userCommand));
    }

    @PostMapping(LOGIN)
    public LoginDTO login(@RequestBody LoginCommand loginCommand){
        return authService.login(loginCommand);
    }



}
