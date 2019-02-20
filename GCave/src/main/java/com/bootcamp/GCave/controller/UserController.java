package com.bootcamp.GCave.controller;


import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.payload.UserRequest;
import com.bootcamp.GCave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    UserService userService;




    @PostMapping(path="/add")
    public @ResponseBody String addNewUser(@Valid @RequestBody UserRequest userRequest) {


        userService.saveUser(userRequest);
        return "User Saved";


    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return  userService.findAll();

    }

    @GetMapping(path="/findByName")
    public @ResponseBody Iterable<User> GetUserByName(@Valid @RequestBody UserRequest userRequest){

        return userService.findByName(userRequest.getName());

    }

    @GetMapping(path="/find")
    public @ResponseBody User GetUserById(@Valid @RequestBody UserRequest userRequest){

            return userService.findById(userRequest);

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteUserById(@Valid @RequestBody UserRequest userRequest){


            userService.softDelete(userRequest.getId());
            return "User deleted";

    }


    @PostMapping(path="/update")
    public @ResponseBody String UpdateUser(@Valid @RequestBody UserRequest userRequest) {


            userService.updateUser(userRequest);

            return "User Updated";

    }

}
