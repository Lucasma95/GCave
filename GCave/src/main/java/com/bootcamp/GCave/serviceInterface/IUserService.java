package com.bootcamp.GCave.serviceInterface;

import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.payload.TransactionRequest;
import com.bootcamp.GCave.payload.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);

    boolean validateUserExist(Long id);


    void saveUser(UserRequest userRequest);

    void updateUser(UserRequest userRequest);

    void saveTransactionUserGame(TransactionRequest transactionRequest);

    void saveTransactionUserMod(TransactionRequest transactionRequest);

    void softDelete(Long id);

    List<User> findByName(String name);
}
