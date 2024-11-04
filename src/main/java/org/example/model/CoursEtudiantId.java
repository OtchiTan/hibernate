package org.example.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class CoursEtudiantId implements java.io.Serializable {
    private static final long serialVersionUID = -5978477773469273922L;
    @Column(name = "ID_COURS", nullable = false)
    private Integer idCours;

    @Column(name = "ID_ETUDIANT", nullable = false)
    private Integer idEtudiant;

    public Integer getIdCours() {
        return idCours;
    }

    public void setIdCours(Integer idCours) {
        this.idCours = idCours;
    }

    public Integer getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CoursEtudiantId entity = (CoursEtudiantId) o;
        return Objects.equals(this.idCours, entity.idCours) &&
                Objects.equals(this.idEtudiant, entity.idEtudiant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCours, idEtudiant);
    }

}