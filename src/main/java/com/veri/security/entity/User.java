package com.veri.security.entity;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users_data")
public class User {


    @Id
    @GeneratedValue
    private int userId;

    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Column(unique = true,nullable = false)
    private String username;

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public User() {

    }

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !obj.getClass().equals(User.class)) {
            return false;
        }
        User user = (User) obj;
        return user.getUserId() == this.userId;
    }

    @Override
    public int hashCode() {
        return userId;
    }
}
