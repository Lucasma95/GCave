package com.bootcamp.GCave.controller;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.model.User;
import com.bootcamp.GCave.payload.UserRequest;
import com.bootcamp.GCave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    UserService userService;




    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser(@RequestBody UserRequest userRequest) {


        userService.saveUser(userRequest);
        return "User Saved";


    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return  userService.findAll();

    }

    @GetMapping(path="/findByName")
    public @ResponseBody Iterable<User> GetUserByName(@RequestBody UserRequest userRequest){

        return userService.findByName(userRequest.getName());

    }

    @GetMapping(path="/find")
    public @ResponseBody User GetUserById(@RequestBody UserRequest userRequest){

            return userService.findById(userRequest.getId());

    }

    @DeleteMapping("/delete")
    public @ResponseBody ResponseEntity DeleteUserById(@RequestBody UserRequest userRequest){


          return  userService.softDelete(userRequest.getId());

    }


    @PostMapping(path="/update")
    public @ResponseBody String UpdateUser(@RequestBody UserRequest userRequest) {

        if(userService.validateUserExist(userRequest.getId())) {

            userService.updateUser(userRequest);

            return "User Updated";
        }
        return "Do not exist any User with that id";


    }

}
