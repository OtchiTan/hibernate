package org.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Promotion {
    @Basic
    @Column(name = "LIBELLE")
    private String libelle;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_PROMOTION")
    private int id;
    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private Collection<Cours> cours;

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int idPromotion) {
        this.id = idPromotion;
    }

    public Promotion(String libelle) {
        this.libelle = libelle;
        cours = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Promotion promotion = (Promotion) o;
        return id == promotion.id && Objects.equals(libelle, promotion.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle, id);
    }

    public Collection<Cours> getCours() {
        return cours;
    }

    public void setCours(Collection<Cours> coursByIdPromotion) {
        this.cours = coursByIdPromotion;
    }
}
