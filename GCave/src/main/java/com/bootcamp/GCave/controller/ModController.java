package com.bootcamp.GCave.controller;


import com.bootcamp.GCave.model.Mod;
import com.bootcamp.GCave.service.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/users")
public class ModController {

    @Autowired
    ModService modService;


    @PostMapping(path="/add")
    public @ResponseBody
    String addNewMod(@Valid @RequestBody Mod mod) {


        modService.save(mod);
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
    public @ResponseBody String UpdateMod(@RequestBody Mod mod ) {

        if(modService.validateModExist(mod.getId())) {
            modService.save(mod);
            return "Mod Updated";
        }
        return "Do not exist any Mod with that id";

    }

}
