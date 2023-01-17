package com.giveandtake.userService.services.users;

import com.giveandtake.userService.entities.User;
import com.giveandtake.userService.exceptions.BusinessException;
import com.giveandtake.userService.exceptions.ExceptionPayload;
import com.giveandtake.userService.exceptions.ExceptionPayloadFactory;
import com.giveandtake.userService.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BusinessException(ExceptionPayloadFactory.USER_NOT_FOUND.get()));
    }

    @Override
    public void deleteUser(String id) {
        userRepository.delete(getUser(id));
    }
}
