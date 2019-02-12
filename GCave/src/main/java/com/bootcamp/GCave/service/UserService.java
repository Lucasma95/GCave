package com.bootcamp.GCave.service;

import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.repository.UserRepository;
import com.bootcamp.GCave.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>) userRepository.findAll();

        return users;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public boolean validateUserExist(Long id) {

        return userRepository.existsById(id);
    }
}
