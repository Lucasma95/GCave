package com.bootcamp.GCave.controller;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
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


    @PostMapping(path="/addd")
    public @ResponseBody
    String adddNewUser(@RequestBody User user) {


        userService.save(user);
        return "User Saved";


    }

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
    public @ResponseBody String UpdateUser(@RequestBody UserRequest userRequest ) {

        if(userService.validateUserExist(userRequest.getId())) {

            userService.updateUser(userRequest);

            return "User Updated";
        }
        return "Do not exist any User with that id";


    }
    @GetMapping(path="/test")
    public @ResponseBody String  teste(){
        long a = 1;
        long b = 2;
        long c = 3;
        User user = new User();
        user.setName("Lucas");
        userService.save(user);
        user.setId(c);
        Item game1 = new Game();
        Item game2 = new Game();
        game1.setId(a);
        game1.setName("Tomb Raider");
        game2.setId(b);
        game2.setName("Uncharted");
        user.getItems().add(game1);
        user.getItems().add(game2);
         userService.save(user);
        return "user saved with games";

    }
}
