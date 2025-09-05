package com.tahkin.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class OneToOneRelation {
    public static void main(String[] args) {
        LaptopForOneToOne lap = new LaptopForOneToOne();
        lap.setlId(1001);
        lap.setName("Dell");
        lap.setRam(64);

        StudentsForOneToOne stud = new StudentsForOneToOne();

        stud.setsName("Nikhat");
        stud.setsId(101);
        stud.setBranch("cse");
        stud.setLaptop(lap);

        Configuration con = new Configuration()
                .configure()
                .addAnnotatedClass(StudentsForOneToOne.class)
                .addAnnotatedClass(LaptopForOneToOne.class);  // <-- ADD THIS
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();

        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();

        session.beginTransaction();

        session.save(stud);
        session.save(lap);

       session.getTransaction().commit();
        session.close();



    }
}
