package org.sesame.pdl.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_eq;
    private String nomEquipe;

    @JsonIgnore
    @OneToMany(mappedBy = "equipe" , cascade= {CascadeType.MERGE})
    private List<User> users;
}
