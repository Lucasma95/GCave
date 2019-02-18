package com.bootcamp.GCave.service;


import com.bootcamp.GCave.exception.AppException;
import com.bootcamp.GCave.exception.Errors;
import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.payload.TransactionRequest;
import com.bootcamp.GCave.payload.UserRequest;
import com.bootcamp.GCave.repository.GameRepository;
import com.bootcamp.GCave.repository.ModRepository;
import com.bootcamp.GCave.repository.UserRepository;
import com.bootcamp.GCave.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    ModRepository modRepository;

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
        user.setActive(true);
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


        //(gameRepository.findById(userRequest.getIdGame()));

        User user = new User();
        user.setName(userRequest.getName());
        user.setActive(true);
        userRepository.save(user);

    }

    @Override
    public void updateUser(UserRequest userRequest) {

        User user = new User();
        user.setId(userRequest.getId());
        user.setName(userRequest.getName());
        user.setActive(true);
        userRepository.save(user);


    }

    @Override
    public void saveTransactionUserGame(TransactionRequest transactionRequest) {
        User user = userRepository.findById(transactionRequest.getIdUser()).orElse(null);
        Item item = gameRepository.findById(transactionRequest.getIdGame()).orElse(null);

        user.getItems().add(item);
        userRepository.save(user);




    }

    @Override
    public void saveTransactionUserMod(TransactionRequest transactionRequest) {
        User user = userRepository.findById(transactionRequest.getIdUser()).orElse(null);
        Item item = modRepository.findById(transactionRequest.getIdMod()).orElse(null);

        user.getItems().add(item);
        userRepository.save(user);
    }

    @Override
    public ResponseEntity softDelete(Long id) {
        if(userRepository.existsById(id)){
        User user = userRepository.findById(id).orElse(null);
        user.setActive(false);
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
        }
        else{

            throw new AppException(Errors.USER_NOT_FOUND);


        }

    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);

    }
}
