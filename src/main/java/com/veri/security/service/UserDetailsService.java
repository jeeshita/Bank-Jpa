package com.veri.security.service;

import com.veri.security.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veri.security.entity.User;
import com.veri.security.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@Transactional
public class UserDetailsService implements IUserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User createUser(User user) {
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User findUserById(int userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
           return user.get();
        }
        throw  new UserNotFoundException();
    }

    @Override
    public User findByUsername(String username){
      User user=  userRepository.findByUsername(username);
        if (user!=null) {
            return user;
        }
        throw  new UserNotFoundException();
    }




}






