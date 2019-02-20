package com.bootcamp.GCave.service;

import com.bootcamp.GCave.exception.AppException;
import com.bootcamp.GCave.exception.Errors;
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
    GameRepository gameRepository;
    @Autowired
    ModRepository modRepository;


    @Override
    public List<Mod> findAll() {
        List<Mod> mods =  modRepository.findAll();

        return mods;
    }

    @Override
    public Mod findById(ModRequest modRequest) {
        if (modRepository.existsById(modRequest.getId())) {

            Mod mod =  modRepository.findById(modRequest.getId()).orElse(null);
            return mod;

        }
        else{
            throw new AppException( "Problem looking for the mod, "+ Errors.MOD_NOT_FOUND);

        }

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


        if (gameRepository.existsById(modRequest.getIdGame())) {

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
        else{
            throw new AppException( "Problem saving the mod, "+ Errors.GAME_NOT_FOUND);

        }




    }

    @Override
    public void updateMod(ModRequest modRequest) {
        if (modRepository.existsById(modRequest.getId())) {

            if( gameRepository.existsById(modRequest.getIdGame())) {

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
            else{
                throw new AppException( "Problem with the update, "+ Errors.GAME_NOT_FOUND);
            }
        }
        else{
            throw new AppException( "Problem with the update, "+Errors.MOD_NOT_FOUND);

        }


    }

    @Override
    public void softDelete(ModRequest modRequest) {

        if (modRepository.existsById(modRequest.getId())) {

            Mod mod = modRepository.findById(modRequest.getId()).orElse(null);
            mod.setActive(false);
            modRepository.save(mod);

        }
        else{
            throw new AppException( "Problem with the softDelete, "+ Errors.MOD_NOT_FOUND);

        }
    }

    @Override
    public List<Mod> findByName(String name) {
        return modRepository.findByName(name);
    }
}
