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
    public @ResponseBody Item GetGameById(@Valid @RequestBody GameRequest gameRequest){

        return gameService.findById(gameRequest);

    }

    @GetMapping(path="/findByName")
    public @ResponseBody Iterable<Game> GetUserByName(@Valid @RequestBody GameRequest gameRequest){

        return gameService.findByName(gameRequest.getName());

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteGameById(@Valid @RequestBody GameRequest gameRequest){

            gameService.softDelete(gameRequest);
            return "Game deleted";

    }


    @PostMapping(path="/update")
    public @ResponseBody String UpdateGame(@Valid @RequestBody GameRequest gameRequest ) {

            gameService.updateGame(gameRequest);
            return "Game Updated";


    }
}
