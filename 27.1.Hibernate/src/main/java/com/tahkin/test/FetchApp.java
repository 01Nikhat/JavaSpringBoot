package com.tahkin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class FetchApp {
    public static void main(String[] args) {
        FetchDataUsingHibernate obj = new FetchDataUsingHibernate();

        Configuration con = new Configuration().configure().addAnnotatedClass(FetchDataUsingHibernate.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        obj = session.get(FetchDataUsingHibernate.class,101);
        tx.commit();
        session.close();
    }
}
