package com.bootcamp.GCave.repository;

import com.bootcamp.GCave.model.Game;
import com.bootcamp.GCave.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByName(String name);
}
