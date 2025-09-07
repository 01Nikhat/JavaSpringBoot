package com.tahkin.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class AppName {
    public static void main(String[] args) throws Exception {
        EmbeddableInsertion name = new EmbeddableInsertion();
        name.setfName("ms");
        name.setmName("Nikhat");
        name.setlName("Parvin");
        NamingConviction obj = new NamingConviction();
        obj.setName(name);
        obj.seteId(101);
        obj.setCity("Kolkata");

        Configuration con = new org.hibernate.cfg.Configuration().configure().addAnnotatedClass(NamingConviction.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();
        session.save(obj);

        tx.commit();
        session.close();

    }

}
