package com.sample;

import com.sample.models.User;

import java.util.List;

public interface UserManager {


    List<User> addUser(User user1);

    void updateUser(User user);

    List<User> listUsers();

    void deleteUser(int id);

    List<User> searchUsers(String searchword);
}

