package com.bootcamp.GCave.controller;

import com.bootcamp.GCave.model.*;
import com.bootcamp.GCave.service.GameService;
import com.bootcamp.GCave.service.TransactionService;
import com.bootcamp.GCave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/purchases")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    UserService userService;
    @Autowired
    GameService gameService;


    @PostMapping(path="/add")
    public @ResponseBody
    String addNewTransaction( @RequestBody Transaction user) {


        transactionService.save(user);
        return "User Saved";


    }
    @GetMapping(path="/test")
    public @ResponseBody
    String TestTransaction( ) {

        User user = new User();
        user.setName("Lucas");
        userService.save(user);

        Description description = new Description("Web descriptionsss","mobile descriptionsss");
        Item game = new Game();
        game.setDescription(description);
        game.setName("Tomb Raider");
        gameService.save(game);

        Transaction transaction = new Transaction();
        transaction.setItem(game);
        transaction.setUser(user);
        transaction.setItemId(2);
        transaction.setUserId(1);

        transactionService.save(transaction);



        return "User Saved";


    }
}
