package org.sesame.pdl.Repository;

import org.sesame.pdl.Entity.Equipe;
import org.sesame.pdl.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface IEquipeRepository extends JpaRepository<Equipe,Integer> {
    Optional<Equipe> findByNomEquipe(String nomEquipe);
}
