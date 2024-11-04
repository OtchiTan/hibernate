package org.example;

/**
 * Hello world!
 *
 */
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

        em.persist(new Utilisateur("gaultier@cs2i.fr", "motDePasse", "Olivier", new Date()));

        ArrayList<Utilisateur> users = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            users.add(new Utilisateur("user" + i + "@free.oom", "root", "User " + i, new Date()));
        }

        em.getTransaction().begin();
        for (Utilisateur utilisateur : users) {
            em.persist(utilisateur);
        }

        List<Utilisateur> savedUsers = em.createNamedQuery("Utilisateur.findAll",Utilisateur.class).getResultList();
        for (Utilisateur user : savedUsers) {
            System.out.println(user.toString());
        }

        Utilisateur user2 = em.createNamedQuery("Utilisateur.findById", Utilisateur.class).setParameter("id", 2).getSingleResult();
        showUser(user2);

        em.remove(em.createNamedQuery("Utilisateur.findById",Utilisateur.class).setParameter("id", 3).getSingleResult());

        users.get(4).setNom("Nom Custom");
        em.merge(users.get(4));

        Utilisateur olivier = em.createNamedQuery("Utilisateur.findByEmail", Utilisateur.class).setParameter("email", "gaultier@cs2i.fr").getSingleResult();
        showUser(olivier);

        List<Utilisateur> filteredUsers = em.createQuery("select u from Utilisateur u where id < 4", Utilisateur.class).getResultList();
        for (Utilisateur user : filteredUsers) {
            System.out.println(user.toString());
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    static void showUser(Utilisateur user) {
        System.out.println(user.getId() + " " + user.getEmail() + " " + user.getNom() + " " + user.getMotDePasse() + " " + user.getDateInscription());
    }
}