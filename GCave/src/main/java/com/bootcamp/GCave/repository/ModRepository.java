package com.bootcamp.GCave.repository;

import com.bootcamp.GCave.model.Mod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModRepository extends CrudRepository<Mod, Long> {
}
