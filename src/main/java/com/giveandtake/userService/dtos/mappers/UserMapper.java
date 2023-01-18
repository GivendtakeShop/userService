package com.giveandtake.userService.dtos.mappers;


import com.giveandtake.userService.commands.UserCommand;
import com.giveandtake.userService.dtos.UserDTO;
import com.giveandtake.userService.entities.Role;
import com.giveandtake.userService.entities.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder passwordEncoder;
    public UserDTO userToUserDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .gender(user.getGender())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .build();
    }
    public User userCommandToUser(UserCommand userCommand){
        return User.builder()
                .userName(userCommand.getUserName())
                .email(userCommand.getEmail())
                .gender(userCommand.getGender())
                .phone(userCommand.getPhone())
                .address(userCommand.getAddress())
                .password(passwordEncoder.encode(userCommand.getPassword()))
                .role(Role.ROLE_CLIENT)
                .build();
    }

}
