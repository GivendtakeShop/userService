package com.giveandtake.userService.services.users;


import com.giveandtake.userService.entities.User;

import java.util.Collection;
import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUser(String id);

    void deleteUser(String id);
}
