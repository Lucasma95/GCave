package com.bootcamp.GCave.controller;


import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.payload.TransactionRequest;
import com.bootcamp.GCave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/transactions")
public class TransactionController {


    @Autowired
    UserService userService;


    @PostMapping(path="/addUserGame")
    public @ResponseBody String addNewTransactionUserGame(@RequestBody TransactionRequest transactionRequest) {


        userService.saveTransactionUserGame(transactionRequest);
        return "Transaction confirm, game added";

    }

    @PostMapping(path="/addUserMod")
    public @ResponseBody String addNewTransactionUserMod(@RequestBody TransactionRequest transactionRequest) {


        userService.saveTransactionUserMod(transactionRequest);
        return "Transaction confirm, mod added";

    }
}
