package org.sesame.pdl.Service;

import org.sesame.pdl.Entity.Equipe;
import org.sesame.pdl.Entity.Tache;

import java.util.List;

public interface ITacheService {

    public Tache saveTache (Tache tache);
    public  Tache updateTache (Tache tache,int idt);
    public void deleteTache(int idt);
    public List<Tache> getAllTache();
    public Tache getByIdTache (int idt);


    public void affecterUserToTache(String fullName, Tache tache);

}
