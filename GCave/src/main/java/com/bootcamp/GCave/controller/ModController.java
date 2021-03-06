package com.bootcamp.GCave.controller;



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
    String addNewMod(@Valid @RequestBody ModRequest modRequest) {


        modService.saveMod(modRequest);
        return "Mod Saved";


    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Mod> getAllMods(){
        return  modService.findAll();

    }

    @GetMapping(path="/find")
    public @ResponseBody Mod GetModById(@Valid @RequestBody ModRequest modRequest){

        return modService.findById(modRequest);

    }
    @GetMapping(path="/findByName")
    public @ResponseBody Iterable<Mod> GetUserByName(@Valid @RequestBody ModRequest modRequest){

        return modService.findByName(modRequest.getName());

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteModById(@Valid @RequestBody ModRequest modRequest){

            modService.softDelete(modRequest);
            return "Mod deleted";


    }


    @PostMapping(path="/update")
    public @ResponseBody String UpdateMod(@Valid @RequestBody ModRequest modRequest ) {


            modService.updateMod(modRequest);
            return "Mod Updated";


    }

}
