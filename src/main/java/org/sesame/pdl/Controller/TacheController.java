package org.sesame.pdl.Controller;

import lombok.AllArgsConstructor;
import org.sesame.pdl.Entity.Project;
import org.sesame.pdl.Entity.Tache;
import org.sesame.pdl.Entity.User;
import org.sesame.pdl.Service.ITacheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Tache")
@CrossOrigin(origins = "http://localhost:4200")

public class TacheController {

    private ITacheService tacheService;

    @GetMapping("/getAll")
    public List<Tache> getAllTache() {
        return tacheService.getAllTache();
    }

    @GetMapping("/getById/{idt}")
    public Tache getByIdTache(@PathVariable int idt) {
        return tacheService.getByIdTache(idt);
    }

    @PostMapping("/addTache")
    public Tache saveTache(@RequestBody Tache tache) {
        return tacheService.saveTache(tache);
    }

    @PutMapping("/updateTache/{idt}")
    public Tache updateTache(@RequestBody Tache tache, @PathVariable int idt) {
        tache.setIdt(idt);
        return tacheService.updateTache(tache, idt);
    }

    @DeleteMapping("/delete/{idt}")
    public void deleteTache(@PathVariable int idt) {

        tacheService.deleteTache(idt);
    }

    @PutMapping("/affecterUserToTache/{fullName}")
    public void affecterUserToTache(@PathVariable String fullName,@RequestBody Tache tache)
    {
       tacheService.affecterUserToTache(fullName,tache);
    }








}
