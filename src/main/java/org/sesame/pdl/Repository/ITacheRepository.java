package org.sesame.pdl.Repository;

import org.sesame.pdl.Entity.Tache;
import org.sesame.pdl.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ITacheRepository extends JpaRepository<Tache,Integer> {
    Optional<Tache> findByNomTache(String nomTache);

}
