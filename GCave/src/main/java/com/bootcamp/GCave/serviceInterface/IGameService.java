package com.bootcamp.GCave.serviceInterface;

import com.bootcamp.GCave.model.Game;

import java.util.List;

public interface IGameService {

    List<Game> findAll();

    Game findById(Long id);

    void save(Game game);

    void deleteById(Long id);


    boolean validateGameExist(Long id);
}
