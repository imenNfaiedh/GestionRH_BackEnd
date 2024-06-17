package org.sesame.pdl.Service;

import org.sesame.pdl.Entity.Equipe;

import java.util.List;

public interface IEquipeService {

    public Equipe saveEquipe (Equipe equipe);
    public  Equipe updateEquipe (Equipe equipe,int id_eq);
    public void deleteEquipe(int id_eq );
    public List<Equipe> getAllEquipe();
    public Equipe getByIdEquipe (int id_eq);

   // public void affecterProjectEquipe (int idProject, Equipe equipe);


}
