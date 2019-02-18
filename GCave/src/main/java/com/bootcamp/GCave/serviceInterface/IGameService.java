package com.bootcamp.GCave.serviceInterface;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.payload.GameRequest;

import java.util.List;

public interface IGameService {

    List<Game> findAll();

    Game findById(Long id);

    void save(Game game);

    void deleteById(Long id);


    boolean validateGameExist(Long id);

    void saveGame(GameRequest gameRequest);

    void updateGame(GameRequest gameRequest);

    void softDelete(Long id);

    List<Game> findByName(String name);
}
