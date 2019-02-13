package com.bootcamp.GCave.controller;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/games")
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewGame(@Valid @RequestBody Game game) {


        gameService.save(game);
        return "Game Saved";

    }


    @GetMapping("/all")
    public @ResponseBody Iterable<Item> getAllGames(){
        return  gameService.findAll();

    }

    @GetMapping(path="/find")
    public @ResponseBody Item GetGameById(@RequestParam Long id){

        return gameService.findById(id);

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteGameById(@RequestParam Long id){
        if(gameService.validateGameExist(id)){
            gameService.deleteById(id);
            return "Game deleted";
        }
        return "Do not exist any Game with that id";
    }


    @PostMapping(path="/update")
    public @ResponseBody String UpdateGame(@RequestBody Game game ) {
        if(gameService.validateGameExist(game.getId())) {
            gameService.save(game);
            return "Game Updated";
        }
        return "Do not exist any Game with that id";

    }
}
