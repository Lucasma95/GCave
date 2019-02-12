package com.bootcamp.GCave.service;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.repository.GameRepository;
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

        List<Game> games = (List<Game>) gameRepository.findAll();

        return games;
    }

    @Override
    public Game findById(Long id) {

        Game game = gameRepository.findById(id).orElse(null);
        return game;
    }

    @Override
    public void save(Game game) {

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
}
