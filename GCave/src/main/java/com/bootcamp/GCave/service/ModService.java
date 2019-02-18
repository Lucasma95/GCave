package com.bootcamp.GCave.service;

import com.bootcamp.GCave.model.Description;
import com.bootcamp.GCave.model.Mod;
import com.bootcamp.GCave.payload.ModRequest;
import com.bootcamp.GCave.repository.GameRepository;
import com.bootcamp.GCave.repository.ItemRepository;
import com.bootcamp.GCave.repository.ModRepository;
import com.bootcamp.GCave.serviceInterface.IModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModService implements IModService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    GameRepository gameRepository;
    @Autowired
    ModRepository modRepository;


    @Override
    public List<Mod> findAll() {
        List<Mod> mods =  modRepository.findAll();

        return mods;
    }

    @Override
    public Mod findById(Long id) {
        Mod mod =  modRepository.findById(id).orElse(null);
        return mod;
    }

    @Override
    public void save(Mod mod) {
        mod.setActive(true);
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

    @Override
    public void saveMod(ModRequest modRequest) {


        Description description = new Description();
        description.setMobileDescription(modRequest.getMobileDescription());
        description.setWebDescription(modRequest.getWebDescription());

        Mod mod = new Mod();
        mod.setActive(true);
        mod.setName(modRequest.getName());
        mod.setGame(gameRepository.findById(modRequest.getIdGame()).orElse(null));
        mod.setDescription(description);


        modRepository.save(mod);


    }

    @Override
    public void updateMod(ModRequest modRequest) {

        Description description = new Description();
        description.setMobileDescription(modRequest.getMobileDescription());
        description.setWebDescription(modRequest.getWebDescription());

        Mod mod = new Mod();
        mod.setActive(true);
        mod.setId(modRequest.getId());
        mod.setName(modRequest.getName());
        mod.setGame(gameRepository.findById(modRequest.getIdGame()).orElse(null));
        mod.setDescription(description);


        modRepository.save(mod);

    }

    @Override
    public void softDelete(Long id) {
        Mod mod = modRepository.findById(id).orElse(null);
        mod.setActive(false);
        modRepository.save(mod);
    }

    @Override
    public List<Mod> findByName(String name) {
        return modRepository.findByName(name);
    }
}
