package com.bootcamp.GCave.controller;



import com.bootcamp.GCave.model.Mod;
import com.bootcamp.GCave.payload.ModRequest;
import com.bootcamp.GCave.service.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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
    public @ResponseBody Mod GetModById(@RequestBody ModRequest modRequest){

        return modService.findById(modRequest.getId());

    }
    @GetMapping(path="/findByName")
    public @ResponseBody Iterable<Mod> GetUserByName(@RequestBody ModRequest modRequest){

        return modService.findByName(modRequest.getName());

    }

    @DeleteMapping("/delete")
    public @ResponseBody String DeleteModById(@RequestBody ModRequest modRequest){
        if(modService.validateModExist(modRequest.getId())){
            modService.softDelete(modRequest.getId());
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
