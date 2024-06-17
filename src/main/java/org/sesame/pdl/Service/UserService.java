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

public class UserService implements IUserService{

    private IUserRepository userRepository;
    private ITacheRepository tacheRepository;
    @Override
    public User saveUser(User user) {
        return userRepository.save(user) ;
    }

    @Override
    public User updateUser(User user, int id) {
        if(!userRepository.existsById(user.getId()))
        {
            throw new RuntimeException("Project not found ");
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getByIdUser(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not not found with id : " +id) );
    }

    /*@Override
    public void affecterTacheToUser(String nomTache, User user) {
        Tache tache = tacheRepository.findByNomTache(nomTache).orElse(null);
        user.getTaches().add(tache);
        userRepository.save(user);
    }*/


}
