package com.bootcamp.GCave.service;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.payload.UserRequest;
import com.bootcamp.GCave.repository.GameRepository;
import com.bootcamp.GCave.repository.ItemRepository;
import com.bootcamp.GCave.repository.UserRepository;
import com.bootcamp.GCave.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

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

    @Override
    public void saveUser(UserRequest userRequest) {


        //(gameRepository.findById(userRequest.getGame()));

        User user = new User();
        user.setName(userRequest.getName());
        userRepository.save(user);

    }

    @Override
    public void updateUser(UserRequest userRequest) {

        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        userRepository.save(user);


    }
}
