package com.bootcamp.GCave.service;


import com.bootcamp.GCave.exception.AppException;
import com.bootcamp.GCave.exception.Errors;
import com.bootcamp.GCave.exception.ResourceException;
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

    //methods------------------------------------------------------------------

    @Override
    public List<User> findAll() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @Override
    public User findById(UserRequest userRequest) {
        if(userRepository.existsById(userRequest.getId())){

            User user = userRepository.findById(userRequest.getId()).orElse(null);
            return user;
        }
        else{

            throw new ResourceException(HttpStatus.NOT_FOUND, "Problem looking for the user, "+Errors.USER_NOT_FOUND);


        }

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




        User user = new User();
        user.setName(userRequest.getName());
        user.setActive(true);
        userRepository.save(user);

    }

    @Override
    public void updateUser(UserRequest userRequest) {
        if (userRepository.existsById(userRequest.getId())) {
            User user = userRepository.findById(userRequest.getId()).orElse(null);
            user.setName(userRequest.getName());
            userRepository.save(user);
        }
        else{
                throw new AppException( "Problem with the update, "+Errors.USER_NOT_FOUND);

            }



    }

    @Override
    public void saveTransactionUserGame(TransactionRequest transactionRequest) {

        if (userRepository.existsById(transactionRequest.getIdUser())) {

            if( gameRepository.existsById(transactionRequest.getIdGame())) {
                User user = userRepository.findById(transactionRequest.getIdUser()).orElse(null);
                Item item = gameRepository.findById(transactionRequest.getIdGame()).orElse(null);
                user.getItems().add(item);
                userRepository.save(user);
            }
            else{
                throw new AppException( "Problem with the purchase, "+ Errors.GAME_NOT_FOUND);
            }
        }
        else{
            throw new AppException( "Problem with the purchase, "+Errors.USER_NOT_FOUND);

        }


    }

    @Override
    public void saveTransactionUserMod(TransactionRequest transactionRequest) {
        if (userRepository.existsById(transactionRequest.getIdUser())) {

            if( modRepository.existsById(transactionRequest.getIdMod())) {
                User user = userRepository.findById(transactionRequest.getIdUser()).orElse(null);
                Item item = modRepository.findById(transactionRequest.getIdMod()).orElse(null);
                user.getItems().add(item);
                userRepository.save(user);
            }
            else{
                throw new ResourceException(HttpStatus.NOT_FOUND, "Problem with the purchase, "+Errors.MOD_NOT_FOUND);
            }
        }
        else{
            throw new ResourceException(HttpStatus.NOT_FOUND, "Problem with the purchase, "+Errors.USER_NOT_FOUND);

        }
    }

    @Override
    public void  softDelete(Long id) {
        if(userRepository.existsById(id)){
            User user = userRepository.findById(id).orElse(null);
            user.setActive(false);
            userRepository.save(user);

        }
        else{

            throw new ResourceException(HttpStatus.NOT_FOUND, "Problem with the softDelete, "+Errors.USER_NOT_FOUND);


        }

    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);

    }
}
