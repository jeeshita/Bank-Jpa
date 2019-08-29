package com.veri.security.repository;

import com.veri.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);

}
