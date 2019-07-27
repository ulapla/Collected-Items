package com.github.ulapla.security;

import com.github.ulapla.model.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
