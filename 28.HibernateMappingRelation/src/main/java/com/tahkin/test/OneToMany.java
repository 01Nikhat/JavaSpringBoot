package com.tahkin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class OneToMany {
    public static void main(String[] args) {
        LaptopOneToMany laptop1 = new LaptopOneToMany();
        laptop1.setlId(1001);
        laptop1.setlName("HP");
        laptop1.setRam(128);

        LaptopOneToMany laptop2 = new LaptopOneToMany();
        laptop2.setlId(1002);
        laptop2.setlName("Dell");
        laptop2.setRam(64);

        StudentOneToMany stud = new StudentOneToMany();
        stud.setsId(101);
        stud.setsName("Naaz");
        stud.setBranch("CSE");

        // set bidirectional relation
        laptop1.setStudent(stud);
        laptop2.setStudent(stud);
        stud.getLaptops().add(laptop1);
        stud.getLaptops().add(laptop2);

        Configuration con = new Configuration().configure()
                .addAnnotatedClass(LaptopOneToMany.class)
                .addAnnotatedClass(StudentOneToMany.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();
        session.beginTransaction();

        session.save(stud);

        session.getTransaction().commit();
        session.close();
    }
}
