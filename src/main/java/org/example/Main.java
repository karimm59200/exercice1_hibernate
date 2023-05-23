package org.example;

import org.example.entity.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        StandardServiceRegistry registre= new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory= new MetadataSources(registre). buildMetadata(). buildSessionFactory();

        Session session = sessionFactory.openSession();



        Produit p = new Produit("air max", "nike",100.00, 2000);
        Produit P1 = new Produit("Zoom", "nike", 100.00, 100);
        Produit P2 =  new Produit("pegasus", "nike", 200.00, 100);
        Produit P3 = new Produit("air force", "nike",  200.00, 100);
        Produit P4 = new Produit("stan smith", "adidas", 100.00, 100);
        Produit P5 = new Produit("superstar", "adidas",  80.00, 100);

        session.getTransaction().begin();
        session.save(p);
        session.save(P1);
        session.save(P2);
        session.save(P3);
        session.save(P4);
        session.save(P5);


        System.out.println("ID du produit : " + p.getId()  + " " + p.getMarque() + " " + p.getReference() + " " + p.getStock() + " " + p.getPrice());
        System.out.println("ID du produit : " + P1.getId());
        System.out.println("ID du produit : " + P2.getId());
        System.out.println("ID du produit : " + P3.getId());

        // recupération d'un produit par son id
        Produit p2 = session.load(Produit.class, 2);
        System.out.println("******************* produit avec l'id 2 ***************************");
        System.out.println(p2.getMarque() + " " + p2.getReference() + " " + p2.getStock() + " " + p2.getPrice());

        // suppression d'un produit par son id
        Produit p3 = session.load(Produit.class, 3);
        session.delete(p3);


        // modification d'un produit par son id
        System.out.println("*******************  MODIFICATION ET MISE 0 JOUR produit avec l'id 1 ***************************");
        Produit p1 = session.load(Produit.class, 1);
        p1.setMarque("reebok");
        session.update(p1);

        session.getTransaction().commit();
          session.close();
          sessionFactory.close();


    }
}