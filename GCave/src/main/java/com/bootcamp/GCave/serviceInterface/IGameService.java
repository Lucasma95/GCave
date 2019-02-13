package com.bootcamp.GCave.serviceInterface;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;

import java.util.List;

public interface IGameService {

    List<Item> findAll();

    Item findById(Long id);

    void save(Item game);

    void deleteById(Long id);


    boolean validateGameExist(Long id);
}
