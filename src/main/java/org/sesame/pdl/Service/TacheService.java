package org.sesame.pdl.Service;

import lombok.AllArgsConstructor;
import org.sesame.pdl.Entity.Tache;
import org.sesame.pdl.Entity.User;
import org.sesame.pdl.Repository.ITacheRepository;
import org.sesame.pdl.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class TacheService implements ITacheService{

    private ITacheRepository tacheRepository;
    private IUserRepository userRepository;
    @Override
    public Tache saveTache(Tache tache)
    {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache updateTache(Tache tache, int idt) {
        if(!tacheRepository.existsById(tache.getIdt()))
        {
            throw new RuntimeException("Tache not found ");
        }
        return tacheRepository.save(tache);
    }

    @Override
    public void deleteTache(int idt) {
        tacheRepository.deleteById(idt);

    }

    @Override
    public List<Tache> getAllTache() {
        return (List<Tache>) tacheRepository.findAll();
    }

    @Override
    public Tache getByIdTache(int idt) {
        return tacheRepository.findById(idt)
                .orElseThrow(() -> new RuntimeException("Project not not found with id : " +idt) );
    }

    @Override
    public void affecterUserToTache(String fullName, Tache tache) {
        User user = userRepository.findByFullName(fullName).orElse(null);
        tache.setUser(user);
        tacheRepository.save(tache);
    }


}
