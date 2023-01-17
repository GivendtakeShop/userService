package com.giveandtake.userService.services;

import com.giveandtake.userService.commands.LoginCommand;
import com.giveandtake.userService.commands.UserCommand;
import com.giveandtake.userService.dtos.LoginDTO;
import com.giveandtake.userService.dtos.mappers.UserMapper;
import com.giveandtake.userService.entities.User;
import com.giveandtake.userService.exceptions.BusinessException;
import com.giveandtake.userService.exceptions.ExceptionPayloadFactory;
import com.giveandtake.userService.repositories.UserRepository;
import com.giveandtake.userService.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    @Override
    public User signUp(UserCommand userCommand) {
        userCommand.validate();

        if(userRepository.existsByEmail(userCommand.getEmail())){
            throw new BusinessException(ExceptionPayloadFactory.EMAIL_ALREADY_USED.get());
        }

        return userRepository.save(userMapper.userCommandToUser((userCommand)));
    }

    @Override
    public LoginDTO login(LoginCommand loginCommand) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginCommand.getEmail(), loginCommand.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return LoginDTO.builder()
                .token(jwt)
                .build();
    }
}
