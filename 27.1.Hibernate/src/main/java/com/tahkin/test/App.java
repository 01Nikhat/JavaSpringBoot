package com.tahkin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        HibernateDemo obj = new HibernateDemo();

        obj.setUserId(102);
        obj.setUserName("Naaz");
        obj.setUserDesig("SDE2");

        // Load hibernate.cfg.xml and annotated class
        Configuration con = new Configuration().configure().addAnnotatedClass(HibernateDemo.class);

        // Create ServiceRegistry
        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(con.getProperties())
                .build();

        // Build SessionFactory
        SessionFactory sf = con.buildSessionFactory(reg);

        // Open session
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        session.save(obj);

        tx.commit();
        session.close();
    }
}
