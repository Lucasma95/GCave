package com.bootcamp.GCave.controller;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.payload.GameRequest;
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
    public @ResponseBody String addNewGame(@Valid @RequestBody GameRequest gameRequest) {


        gameService.saveGame(gameRequest);
        return "Game Saved";

    }


    @GetMapping("/all")
    public @ResponseBody Iterable<Game> getAllGames(){
        return  gameService.findAll();

    }

    @GetMapping(path="/find")
    public @ResponseBody Item GetGameById(@RequestBody GameRequest gameRequest){

        return gameService.findById(gameRequest.getId());

    }

    @GetMapping(path="/findByName")
    public @ResponseBody Iterable<Game> GetUserByName(@RequestBody GameRequest gameRequest){

        return gameService.findByName(gameRequest.getName());

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteGameById(@RequestBody GameRequest gameRequest){
        if(gameService.validateGameExist(gameRequest.getId())){
            gameService.softDelete(gameRequest.getId());
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
