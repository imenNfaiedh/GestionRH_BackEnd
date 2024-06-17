package org.sesame.pdl.Repository;

import org.sesame.pdl.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IUserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByNomAndPrenom(String nom, String prenom);
    default Optional<User> findByFullName(String fullName) {
        String[] parts = fullName.split(" ");
        if (parts.length == 2) {
            String prenom = parts[0];
            String nom = parts[1];
            return findByNomAndPrenom(nom, prenom);
        } else {
            return Optional.empty();
        }
    }




}
