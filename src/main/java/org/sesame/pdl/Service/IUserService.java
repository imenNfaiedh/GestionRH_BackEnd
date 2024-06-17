package org.sesame.pdl.Service;

import org.sesame.pdl.Entity.Tache;
import org.sesame.pdl.Entity.User;

import java.util.List;

public interface IUserService {

    public User saveUser (User user);
    public  User updateUser (User user,int id);
    public void deleteUser(int id);
    public List<User> getAllUser();
    public User getByIdUser (int id);
    /*public void affecterTacheToUser (String nomTache , User user);*/


}
