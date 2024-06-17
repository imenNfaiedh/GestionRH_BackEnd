package org.sesame.pdl.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.sesame.pdl.Enum.Role;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String email ;
    private String pwd;
    private int tel;

    @Transient
    private String fullName;

    public String getFullName() {
        return this.prenom + " " + this.nom;
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(mappedBy = "user"  )
    private List<Project> projects;

    @ManyToOne
    private Equipe equipe;

    @JsonIgnore
    @OneToMany(mappedBy = "user" )
    private List<Tache> taches;
}
