package com.bootcamp.GCave.service;

import com.bootcamp.GCave.model.Mod;
import com.bootcamp.GCave.repository.ModRepository;
import com.bootcamp.GCave.serviceInterface.IModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModService implements IModService {

    @Autowired
    ModRepository modRepository;


    @Override
    public List<Mod> findAll() {
        List<Mod> mods = (List<Mod>) modRepository.findAll();

        return mods;
    }

    @Override
    public Mod findById(Long id) {
        Mod mod = modRepository.findById(id).orElse(null);
        return mod;
    }

    @Override
    public void save(Mod mod) {
        modRepository.save(mod);

    }

    @Override
    public void deleteById(Long id) {
        modRepository.deleteById(id);

    }

    @Override
    public boolean validateModExist(Long id) {

        return modRepository.existsById(id);
    }
}
