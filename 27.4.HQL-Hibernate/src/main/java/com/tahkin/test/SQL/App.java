package com.tahkin.test.SQL;

import com.tahkin.test.HQL.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class App {
    public static void main(String[] args) {

        // Hibernate setup
        Configuration con = new Configuration().configure().addAnnotatedClass(Students.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);

        Session session1 = sf.openSession();
        session1.beginTransaction();

        // -------------------- MODERN NATIVE QUERY --------------------
        // use table name (student_tbl assumed here)
        List<Students> students = session1
                .createNativeQuery("SELECT * FROM School_tbl WHERE marks > :m", Students.class)
                .setParameter("m", 50)  // safer than hardcoding
                .getResultList();

        for (Students s : students) {
            System.out.println(s);
        }

        session1.getTransaction().commit();
        session1.close();
        sf.close();
    }
}
