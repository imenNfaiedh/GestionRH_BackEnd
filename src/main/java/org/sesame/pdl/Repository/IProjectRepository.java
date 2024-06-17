package org.sesame.pdl.Repository;

import org.sesame.pdl.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IProjectRepository extends JpaRepository<Project,Integer> {
}
