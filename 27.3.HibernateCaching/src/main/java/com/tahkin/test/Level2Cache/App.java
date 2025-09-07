package com.tahkin.test.Level2Cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Students stud = null;

        // ---------------- Hibernate Configuration ----------------
        // 1. Load hibernate.cfg.xml and add Students entity
        //    This includes DB settings + cache settings
        Configuration con = new Configuration()
                .configure()  // loads hibernate.cfg.xml
                .addAnnotatedClass(Students.class);

        // 2. Build service registry
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties())
                .build();

        // 3. Build SessionFactory (heavy object, should be singleton in real apps)
        //    SessionFactory also holds reference to Second Level Cache
        SessionFactory sf = con.buildSessionFactory(reg);


        // ---------------- First Session ----------------
        Session session1 = sf.openSession();
        session1.beginTransaction();

        // 4. Fetch entity with id=302 from DB (first time)
        //    Since this is first query, Hibernate will hit the database.
        //    After fetching, it stores entity in:
        //       a) Session1 cache (First Level)
        //       b) Second Level Cache (EhCache)
        stud = (Students) session1.get(Students.class, 302);

        System.out.println("First Session Fetch: " + stud);

        session1.getTransaction().commit();
        session1.close(); // Now Session1 cache is cleared, but L2 cache still holds entity


        // ---------------- Second Session ----------------
        Session session2 = sf.openSession();
        session2.beginTransaction();

        // 5. Fetch entity with same id=302 again
        //    This time Hibernate will NOT hit the DB.
        //    Instead, it checks Second Level Cache and gets entity from there.
        stud = (Students) session2.get(Students.class, 302);

        System.out.println("Second Session Fetch (from L2 cache): " + stud);

        session2.getTransaction().commit();
        session2.close();

        // ✅ Close SessionFactory to stop background threads
        sf.close();

        System.out.println("Program finished, Hibernate shutdown.");

        // ---------------- Explanation ----------------
        // First time (Session1) -> DB query is executed and entity is cached in L2.
        // Second time (Session2) -> DB query is skipped, entity is fetched from L2 cache.
        // This proves that Second Level Cache is working.
    }
}
