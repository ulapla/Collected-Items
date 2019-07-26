package com.github.ulapla.security;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);
}
