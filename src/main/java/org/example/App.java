package org.example;

import org.example.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        em = emf.createEntityManager();

        em.getTransaction().begin();

        Promotion promotion = new Promotion("P17 les bests");
        for (int i = 1; i < 5; i++) {
            promotion.getCours().add(new Cour("JAVA Pro " + i, LocalDate.now(), i * 60, "C le java la", promotion));
        }

        em.persist(promotion);

        ArrayList<Etudiant> etudiants = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Etudiant etudiant = new Etudiant("Etudiant " + i);
            etudiants.add(etudiant);
            em.persist(etudiant);
        }

        souscrireAUnePromotion(promotion, etudiants);

        //em.persist(promotion);

        showPromotion(promotion);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    static void souscrireAUnePromotion(Promotion promotion, ArrayList<Etudiant> etudiants) {
        float i = 0.0F;
        for (Cour cour : promotion.getCours()) {
            for (Etudiant etudiant : etudiants) {
                CoursEtudiantId coursEtudiantId = new CoursEtudiantId();

                coursEtudiantId.setIdCours(cour.getId());
                coursEtudiantId.setIdEtudiant(etudiant.getId());

                CoursEtudiant coursEtudiant = new CoursEtudiant();

                coursEtudiant.setIdEtudiant(etudiant);
                coursEtudiant.setIdCours(cour);
                coursEtudiant.setId(coursEtudiantId);

                coursEtudiant.setNote(i);

                em.persist(coursEtudiant);

                cour.getCoursEtudiants().add(coursEtudiant);
                etudiant.getCoursEtudiants().add(coursEtudiant);

                i++;
            }
        }
    }

    static void showPromotion(Promotion promotion) {
        System.out.println("Promotion[" + promotion.getId() + "]");
        for (Cour cour : promotion.getCours()) {
            showCour(cour);
        }
    }

    static void showCour(Cour cour) {
        System.out.println("Cour[" + cour.getId() + "]");
        for (CoursEtudiant coursEtudiant : cour.getCoursEtudiants()) {
            System.out.println("Etudiant[" + coursEtudiant.getIdEtudiant().getId() + "]");
        }
    }
}