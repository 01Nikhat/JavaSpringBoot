package com.tahkin.test.cacheLevel1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Students stud = null;

        // Load Hibernate configuration (hibernate.cfg.xml)
        // and map the Students entity class
        Configuration con = new Configuration().configure().addAnnotatedClass(Students.class);

        // Create ServiceRegistry (required for SessionFactory)
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties()).build();

        // Build SessionFactory (heavy object, should be created once per application)
        SessionFactory sf = con.buildSessionFactory(reg);

        // -------------------- First Session --------------------
        Session session1 = sf.openSession();  // opens first session (new L1 cache)
        session1.beginTransaction();

        // Fetching student with ID=301
        // 👉 First time: Hibernate goes to the database
        stud = (Students) session1.get(Students.class, 301);
        System.out.println("First fetch (DB hit): " + stud);

        // Fetching same student again in the SAME session
        // 👉 This time: Hibernate does NOT go to DB
        // 👉 Instead, it returns the object from **Level 1 cache**
        stud = (Students) session1.get(Students.class, 301);
        System.out.println("Second fetch (L1 Cache): " + stud);

        session1.getTransaction().commit();
        session1.close(); // closing session also clears Level 1 cache

        // -------------------- Second Session --------------------
        Session session2 = sf.openSession();  // opens second session (new L1 cache again)
        session2.beginTransaction();

        // Fetching same student again in a NEW session
        // 👉 Level 1 cache is session-scoped, so cache from session1 is gone
        // 👉 Hibernate will go to the database again
        stud = (Students) session2.get(Students.class, 301);
        System.out.println("Third fetch (new session, DB hit again): " + stud);

        session2.getTransaction().commit();
        session2.close();

        // -------------------- Key Notes --------------------
        // 1. Hibernate Level 1 cache is ENABLED by default.
        // 2. It is scoped to a single Session (not shared across sessions).
        // 3. Within one session, the same entity (by primary key) is fetched from cache,
        //    not from the DB.
        // 4. Once the session is closed, Level 1 cache is cleared.
        // 5. To share cache across sessions, you need to configure Level 2 cache.
    }
}
