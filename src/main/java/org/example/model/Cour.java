package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cours")
public class Cour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COURS", nullable = false)
    private Integer id;

    @Column(name = "LIBELLE_COURS", length = 25)
    private String libelleCours;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PROMOTION", nullable = false)
    private Promotion idPromotion;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "DUREE")
    private Integer duree;

    @Column(name = "DESCRIPTION", length = 20)
    private String description;

    @ManyToMany
    @JoinTable(name = "cours_etudiant",
            joinColumns = @JoinColumn(name = "ID_COURS"),
            inverseJoinColumns = @JoinColumn(name = "ID_ETUDIANT"))
    private Set<Etudiant> etudiants = new LinkedHashSet<>();

    public Cour() {}

    public Cour(String libelleCours, LocalDate date, Integer duree, String description, Promotion promotion) {
        this.libelleCours = libelleCours;
        this.date = date;
        this.duree = duree;
        this.description = description;
        this.idPromotion = promotion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelleCours() {
        return libelleCours;
    }

    public void setLibelleCours(String libelleCours) {
        this.libelleCours = libelleCours;
    }

    public Promotion getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(Promotion idPromotion) {
        this.idPromotion = idPromotion;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

}