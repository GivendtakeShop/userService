package com.giveandtake.userService.controllers;

import com.giveandtake.userService.dtos.UserDTO;
import com.giveandtake.userService.dtos.mappers.UserMapper;
import com.giveandtake.userService.services.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.giveandtake.userService.constants.PathConstant.USERS;
import static com.giveandtake.userService.constants.PathConstant.V1;

@RestController
@RequestMapping(V1+USERS)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDTO> getProducts(){
        return userService.getUsers()
                .stream().map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDTO getProduct(@PathVariable String id) {
        return  userMapper.userToUserDTO(userService.getUser(id));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id){
        userService.deleteUser(id);
    }


}
