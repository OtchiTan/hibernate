package org.example.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROMOTION", nullable = false)
    private Integer id;

    @Column(name = "LIBELLE", length = 20)
    private String libelle;

    @OneToMany(mappedBy = "idPromotion", cascade = CascadeType.ALL)
    private Set<Cour> cours = new LinkedHashSet<>();

    public Promotion() {}

    public Promotion(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Cour> getCours() {
        return cours;
    }

    public void setCours(Set<Cour> cours) {
        this.cours = cours;
    }

}