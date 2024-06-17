package org.sesame.pdl.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idt;
    private String nomTache;
    private String description ;
    private Date date_deb;
    private Date date_fin;


    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;




}
