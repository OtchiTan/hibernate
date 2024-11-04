package org.example.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Cours {
    @Basic
    @Column(name = "LIBELLE_COURS")
    private String libelleCours;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_COURS")
    private int id;
    @Basic
    @Column(name = "DATE")
    private Date date;
    @Basic
    @Column(name = "DUREE")
    private Integer duree;
    @Basic
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToOne
    @JoinColumn(name = "ID_PROMOTION", referencedColumnName = "ID_PROMOTION", nullable = false)
    private Promotion promotion;

    public Cours(String libelle, Date date, int duree, String description, Promotion promotion) {
        this.libelleCours = libelle;
        this.date = date;
        this.duree = duree;
        this.description = description;
        this.promotion = promotion;
    }

    public String getLibelleCours() {
        return libelleCours;
    }

    public void setLibelleCours(String libelleCours) {
        this.libelleCours = libelleCours;
    }

    public int getId() {
        return id;
    }

    public void setId(int idCours) {
        this.id = idCours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cours cours = (Cours) o;
        return id == cours.id && Objects.equals(libelleCours, cours.libelleCours) && Objects.equals(date, cours.date) && Objects.equals(duree, cours.duree) && Objects.equals(description, cours.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelleCours, id, date, duree, description);
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotionByIdPromotion) {
        this.promotion = promotionByIdPromotion;
    }
}
