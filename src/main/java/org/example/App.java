package org.example;

/**
 * Hello world!
 *
 */
import org.example.model.Cours;
import org.example.model.Promotion;
import org.example.model.Utilisateur;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Promotion promotion = new Promotion("P17 les bests");
        for (int i = 1; i < 5; i++) {
            promotion.getCours().add(new Cours("JAVA Pro", new java.sql.Date(5), i * 60, "C le java la", promotion));
        }

        em.getTransaction().begin();

        em.persist(promotion);

        showPromotion(promotion);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    static void showPromotion(Promotion promotion) {
        System.out.println("Promotion[" + promotion.getId() + "]");
        for (Cours cours : promotion.getCours()) {
            System.out.println("Cours[" + cours.getId() + "]");
        }
    }
}