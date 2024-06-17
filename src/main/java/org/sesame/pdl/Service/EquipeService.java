package org.sesame.pdl.Service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sesame.pdl.Entity.Equipe;
import org.sesame.pdl.Entity.Project;
import org.sesame.pdl.Repository.IEquipeRepository;
import org.sesame.pdl.Repository.IProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class EquipeService implements IEquipeService{

    private IEquipeRepository equipeRepository;
    private IProjectRepository projectRepository;
    @Override
    public Equipe saveEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe equipe, int id_eq) {
        if(!equipeRepository.existsById(equipe.getId_eq()))
        {
            throw new RuntimeException("Equipe not found ");
        }
        return equipeRepository.save(equipe);
    }

    @Override
    public void deleteEquipe(int id_eq) {
        equipeRepository.deleteById(id_eq);

    }

    @Override
    public List<Equipe> getAllEquipe() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    @Override
    public Equipe getByIdEquipe(int id_eq) {
        return equipeRepository.findById(id_eq)
                .orElseThrow(() -> new RuntimeException("Equipe not not found with id : " +id_eq) );
    }



    /*@Override
    public void affecterProjectEquipe(int idProject, Equipe equipe) {

        Project project = projectRepository.findById(idProject).orElse(null);
       if (project != null) {
           // Ajouter le projet à l'équipe
           equipe.getProjects().add(project);
           // Associer l'équipe au projet
           project.setEquipe(equipe);

           // Sauvegarder les deux entités
           projectRepository.save(project);
           equipeRepository.save(equipe);
       } else {
           throw new RuntimeException("Project not found with ID: " + idProject);
       }




    }*/
}
