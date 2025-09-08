package com.tahkin.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Students stud = new Students();
        stud.setsId(101);
        stud.setsName("naheed");
        stud.setMarks(89);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("storePU");
        EntityManager em  = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(stud);

        em.getTransaction().commit();
        System.out.println( "Hello World!" );
    }
}
