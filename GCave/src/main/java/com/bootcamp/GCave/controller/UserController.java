package com.bootcamp.GCave.controller;

import com.bootcamp.GCave.model.User;
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
    public @ResponseBody
    String addNewUser(@Valid @RequestBody User user) {


        userService.save(user);
        return "User Saved";


    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return  userService.findAll();

    }

    @GetMapping(path="/find")
    public @ResponseBody User GetUserById(@RequestParam Long id){

        return userService.findById(id);

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteUserById(@RequestParam Long id){
        if(userService.validateUserExist(id)){
            userService.deleteById(id);
            return "User deleted";
        }
        return "Do not exist any User with that id";
    }


    @PostMapping(path="/update")
    public @ResponseBody String UpdateUser(@RequestBody User user ) {

        if(userService.validateUserExist(user.getId())) {
            userService.save(user);

            return "User Updated";
        }
        return "Do not exist any User with that id";


    }
}
