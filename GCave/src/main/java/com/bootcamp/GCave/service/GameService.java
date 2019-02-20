package com.bootcamp.GCave.service;

import com.bootcamp.GCave.exception.AppException;
import com.bootcamp.GCave.exception.Errors;
import com.bootcamp.GCave.model.Description;
import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.payload.GameRequest;
import com.bootcamp.GCave.repository.GameRepository;
import com.bootcamp.GCave.repository.ItemRepository;
import com.bootcamp.GCave.serviceInterface.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService {

    @Autowired
    GameRepository gameRepository;


    @Override
    public List<Game> findAll() {

        List<Game> games =  gameRepository.findAll();

        return games;
    }

    @Override
    public Game findById(GameRequest gameRequest) {

        if (gameRepository.existsById(gameRequest.getId())) {

            Game game = gameRepository.findById(gameRequest.getId()).orElse(null);
            return game;

        }
        else{
            throw new AppException( "Problem looking for the game, "+ Errors.GAME_NOT_FOUND);

        }


    }

    @Override
    public void save(Game game) {
        game.setActive(true);
        gameRepository.save(game);

    }

    @Override
    public void deleteById(Long id) {

        gameRepository.deleteById(id);

    }

    @Override
    public boolean validateGameExist(Long id) {
        return gameRepository.existsById(id);
    }

    @Override
    public void saveGame(GameRequest gameRequest) {


            Description description = new Description();
            description.setMobileDescription(gameRequest.getMobileDescription());
            description.setWebDescription(gameRequest.getWebDescription());

            Game game = new Game();
            game.setActive(true);
            game.setName(gameRequest.getName());
            game.setDescription(description);

            gameRepository.save(game);


    }

    @Override
    public void updateGame(GameRequest gameRequest) {
        if (gameRepository.existsById(gameRequest.getId())) {

            Description description = new Description();
            description.setMobileDescription(gameRequest.getMobileDescription());
            description.setWebDescription(gameRequest.getWebDescription());

            Game game = gameRepository.findById(gameRequest.getId()).orElse(null);
            game.setActive(true);
            game.setName(gameRequest.getName());
            game.setDescription(description);
            gameRepository.save(game);
        }
        else{
            throw new AppException( "Problem with the update, "+ Errors.GAME_NOT_FOUND);

        }


    }

    @Override
    public void softDelete(GameRequest gameRequest) {

        if (gameRepository.existsById(gameRequest.getId())) {

            Game game = gameRepository.findById(gameRequest.getId()).orElse(null);
            game.setActive(false);
            gameRepository.save(game);

        }
        else{
            throw new AppException( "Problem with the softDelete, "+ Errors.GAME_NOT_FOUND);

        }

    }

    @Override
    public List<Game> findByName(String name) {
       return gameRepository.findByName(name);
    }


}
