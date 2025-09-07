package com.tahkin.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ManyToMany {
    public static void main(String[] args) {
        // Create laptops
        LaptopManyToMany laptop1 = new LaptopManyToMany();
        laptop1.setlId(2001);
        laptop1.setlName("Dell");
        laptop1.setRam(16);

        LaptopManyToMany laptop2 = new LaptopManyToMany();
        laptop2.setlId(2002);
        laptop2.setlName("HP");
        laptop2.setRam(32);

        // Create students
        StudentManyToMany student1 = new StudentManyToMany();
        student1.setsId(301);
        student1.setsName("Nikhat");
        student1.setBranch("CSE");

        StudentManyToMany student2 = new StudentManyToMany();
        student2.setsId(302);
        student2.setsName("Naaz");
        student2.setBranch("IT");

        // Mapping relationships
        student1.getLaptops().add(laptop1);
        student1.getLaptops().add(laptop2);

        student2.getLaptops().add(laptop1);

        laptop1.getStudents().add(student1);
        laptop1.getStudents().add(student2);

        laptop2.getStudents().add(student1);

        // Hibernate configuration
        Configuration con = new Configuration().configure()
                .addAnnotatedClass(StudentManyToMany.class)
                .addAnnotatedClass(LaptopManyToMany.class);

        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);

        Session session = sf.openSession();
        session.beginTransaction();

        // Save data
        session.save(student1);
        session.save(student2);

        session.getTransaction().commit();
        session.close();
    }
}
