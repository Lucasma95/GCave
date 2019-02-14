package com.bootcamp.GCave.serviceInterface;

import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.payload.UserRequest;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);

    boolean validateUserExist(Long id);


    void saveUser(UserRequest userRequest);

    void updateUser(UserRequest userRequest);
}
