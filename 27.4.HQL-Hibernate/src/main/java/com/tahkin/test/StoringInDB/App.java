package com.tahkin.test.StoringInDB;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {

        // Hibernate setup
        Configuration con = new Configuration().configure().addAnnotatedClass(Students.class);
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf = con.buildSessionFactory(reg);

        Session session1 = sf.openSession();  // opens first session (new L1 cache)
        session1.beginTransaction();

        Random r = new Random();

        // -------------------- Insert Sample Data --------------------
        // Uncomment this block if you want to insert sample data into DB
//        for (int i = 1; i <= 50; i++) {
//            Students s = new Students();
//            s.setsId(i);
//            s.setsName("name " + i);
//            s.setMarks(r.nextInt(100));
//            session1.save(s);
//        }

        // -------------------- QUERY 1 --------------------
        // Fetch all Students with marks > 50
        // "from Students" returns ENTIRE entity objects -> so we store result in List<Students>
        Query q = session1.createQuery("from Students where marks > 50");
        List<Students> students = q.list();  // multiple Students -> use List<Students>

        for (Students s : students) {
            System.out.println(s);
        }

        // -------------------- QUERY 2 --------------------
        // Fetch a single Student with sId = 7
        // We are querying entity again -> returns Students object
        Query query2 = session1.createQuery("from Students where sId = 7");

        // Since we expect ONE row only -> use getSingleResult()
        Students stud = (Students) query2.getSingleResult();

        System.out.println(stud);

        // -------------------- QUERY 3 --------------------
        // Fetch only selected columns (sName, marks) instead of entire Student entity
        // This is a projection query -> Hibernate returns each row as Object[]
        Query query3 = session1.createQuery("select sName, marks from Students where marks > 50");

        // Each row contains 2 columns -> List<Object[]>
        List<Object[]> resultList = query3.list();

        for (Object[] row : resultList) {
            String name = (String) row[0];  // column 1 = sName
            int marks = (int) row[1];       // column 2 = marks
            System.out.println("Name: " + name + ", Marks: " + marks);
        }

        // -------------------- QUERY 4 --------------------
        // Aggregation query (SUM of marks)
        // Since it's an aggregate, Hibernate returns single value, not multiple rows
        int b = 60;
        Query query4 = session1.createQuery("select sum(marks) from Students s where s.marks > :b");
        query4.setParameter("b", b);

        // sum(marks) returns a single result -> use uniqueResult()
        // Type depends on DB: in MySQL/Postgres it's Long by default
        Long sumMarks = (Long) query4.uniqueResult();
        System.out.println("Sum of marks > " + b + " = " + sumMarks);

        // -------------------- End Transaction --------------------
        session1.getTransaction().commit();
        session1.close();
        sf.close();
    }
}
