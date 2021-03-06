package com.github.ulapla.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {

    private final com.github.ulapla.model.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       com.github.ulapla.model.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public com.github.ulapla.model.User getUser() {return user;}
}
