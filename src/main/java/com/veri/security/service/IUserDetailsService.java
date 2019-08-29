package com.veri.security.service;

import com.veri.security.entity.User;

public interface IUserDetailsService {

    User createUser(User user);

    User findUserById(int userId);

    User findByUsername(String username);
}
