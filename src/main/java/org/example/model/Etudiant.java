package org.example.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ETUDIANT", nullable = false)
    private Integer id;

    @Column(name = "NOM", length = 25)
    private String nom;

    @ManyToMany(mappedBy = "etudiants", cascade = CascadeType.ALL)
    private Set<Cour> cours = new LinkedHashSet<>();

    public Etudiant(String nom) {
        this.nom = nom;
        this.cours = new LinkedHashSet<>();
    }

    public Etudiant() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Cour> getCours() {
        return cours;
    }

    public void setCours(Set<Cour> cours) {
        this.cours = cours;
    }
}