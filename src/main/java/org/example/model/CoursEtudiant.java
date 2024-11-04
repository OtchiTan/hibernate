package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "cours_etudiant")
public class CoursEtudiant {
    @EmbeddedId
    private CoursEtudiantId id;

    @MapsId("idCours")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COURS", nullable = false)
    private Cour idCours;

    @MapsId("idEtudiant")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ETUDIANT", nullable = false)
    private Etudiant idEtudiant;

    public CoursEtudiantId getId() {
        return id;
    }

    public void setId(CoursEtudiantId id) {
        this.id = id;
    }

    public Cour getIdCours() {
        return idCours;
    }

    public void setIdCours(Cour idCours) {
        this.idCours = idCours;
    }

    public Etudiant getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Etudiant idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

}