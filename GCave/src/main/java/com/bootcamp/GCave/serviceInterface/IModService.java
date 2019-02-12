package com.bootcamp.GCave.serviceInterface;

import com.bootcamp.GCave.model.Mod;

import java.util.List;

public interface IModService {

    List<Mod> findAll();

    Mod findById(Long id);

    void save(Mod mod);

    void deleteById(Long id);


    boolean validateModExist(Long id);
}
