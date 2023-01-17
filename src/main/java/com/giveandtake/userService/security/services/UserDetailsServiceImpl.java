package com.giveandtake.userService.security.services;

import com.giveandtake.userService.entities.User;
import com.giveandtake.userService.exceptions.BusinessException;
import com.giveandtake.userService.exceptions.ExceptionPayloadFactory;
import com.giveandtake.userService.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.USER_NOT_FOUND.get()));

        return UserDetailsImpl.build(user);
    }
}