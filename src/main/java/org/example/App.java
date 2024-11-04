package org.example;

import org.example.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Promotion promotion = new Promotion("P17 les bests");
        for (int i = 1; i < 5; i++) {
            promotion.getCours().add(new Cour("JAVA Pro " + i, LocalDate.now(), i * 60, "C le java la", promotion));
        }

        ArrayList<Etudiant> etudiants = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Etudiant etudiant = new Etudiant("Etudiant " + i);
            etudiants.add(etudiant);
            em.persist(etudiant);
        }

        souscrireAUnePromotion(promotion, etudiants);

        em.persist(promotion);

        showPromotion(promotion);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    static void souscrireAUnePromotion(Promotion promotion, ArrayList<Etudiant> etudiants) {
        promotion.getCours().forEach(cour -> {
            etudiants.forEach(etudiant -> {
                cour.getEtudiants().add(etudiant);
                etudiant.getCours().add(cour);
            });
        });
    }

    static void showPromotion(Promotion promotion) {
        System.out.println("Promotion[" + promotion.getId() + "]");
        for (Cour cour : promotion.getCours()) {
            showCour(cour);
        }
    }

    static void showCour(Cour cour) {
        System.out.println("Cour[" + cour.getId() + "]");
        for (Etudiant etudiant : cour.getEtudiants()) {
            System.out.println("Etudiant[" + etudiant.getId() + "]");
        }
    }
}