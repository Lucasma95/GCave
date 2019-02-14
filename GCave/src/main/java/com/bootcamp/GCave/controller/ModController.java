package com.bootcamp.GCave.controller;


import com.bootcamp.GCave.model.Item;
import com.bootcamp.GCave.model.Mod;
import com.bootcamp.GCave.payload.ModRequest;
import com.bootcamp.GCave.service.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/mods")
public class ModController {

    @Autowired
    ModService modService;


    @PostMapping(path="/add")
    public @ResponseBody
    String addNewMod( @RequestBody ModRequest modRequest) {


        modService.saveMod(modRequest);
        return "Mod Saved";


    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Mod> getAllMods(){
        return  modService.findAll();

    }

    @GetMapping(path="/find")
    public @ResponseBody Mod GetModById(@RequestParam Long id){

        return modService.findById(id);

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteModById(@RequestParam Long id){
        if(modService.validateModExist(id)){
            modService.deleteById(id);
            return "Mod deleted";
        }
        return "Do not exist any Mod with that id";
    }


    @PostMapping(path="/update")
    public @ResponseBody String UpdateMod(@RequestBody ModRequest modRequest ) {

        if(modService.validateModExist(modRequest.getId())) {
            modService.updateMod(modRequest);
            return "Mod Updated";
        }
        return "Do not exist any Mod with that id";

    }

}
