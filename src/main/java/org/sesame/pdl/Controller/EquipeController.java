package org.sesame.pdl.Controller;

import lombok.AllArgsConstructor;
import org.sesame.pdl.Entity.Equipe;
import org.sesame.pdl.Entity.Project;
import org.sesame.pdl.Service.IEquipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Equipe")
@CrossOrigin(origins = "*")

public class EquipeController {

    private IEquipeService equipeService;

    @GetMapping("/getAll")
    public List<Equipe> getAllEquipe()
    {
        return equipeService.getAllEquipe();
    }

    @GetMapping ("/getById/{id_eq}")
    public Equipe getByIdEquipe (@PathVariable int id_eq)
    {
        return equipeService.getByIdEquipe(id_eq);
    }

    @PostMapping("/addEquipe")
    public Equipe saveEquipe(@RequestBody Equipe equipe)
    {
        return equipeService.saveEquipe(equipe);
    }

    @PutMapping ("/updateEquipe/{id_eq}")
    public Equipe updateEquipe(@RequestBody Equipe equipe , @PathVariable int id_eq )
    {
        equipe.setId_eq(id_eq);
        return equipeService.updateEquipe(equipe,id_eq);
    }

    @DeleteMapping ("/delete/{id_eq}")
    public void deleteEquipe(@PathVariable int id_eq)
    {

        equipeService.deleteEquipe(id_eq);
    }





}
