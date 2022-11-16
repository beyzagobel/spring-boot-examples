package com.beyzagobel.dal;

import com.beyzagobel.entity.User;

import java.util.List;

public interface UserDAL {

    List<User> getAllUsers();

    User getUser(String userId);

    User createUser(User user);

}
