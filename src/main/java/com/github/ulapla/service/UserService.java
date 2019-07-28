package com.github.ulapla.service;

import com.github.ulapla.model.User;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
