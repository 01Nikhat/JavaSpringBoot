package com.tahkin.test;

import java.sql.*;

public class dynamicInsertUsingFunction {
    public static void main(String[] args) throws Exception {

        studentsDataAcessObject obj = new studentsDataAcessObject();

        // 🔹 MUST call connect() before using obj
        obj.connect();

        // Fetch student with ID 103
        Student s1 = obj.getStudent(103);

        if (s1 != null) {
            System.out.println(s1.id + " : " + s1.name);
        } else {
            System.out.println("Student not found!");
        }
    }
}

class studentsDataAcessObject {

    Connection con = null;

    public void connect() {
        String url = "jdbc:mysql://localhost:3306/employees";
        String uname = "nikhat";
        String pass = "Nikhat@7687";

        try {
            con = DriverManager.getConnection(url, uname, pass);
            System.out.println("✅ Database connected successfully");
        } catch (Exception e) {
            System.out.println("❌ Connection error: " + e);
        }
    }

    public Student getStudent(int id) {
        try {
            // the query will select only coloumn that is name
            String query = "SELECT name FROM students WHERE id=" + id;
            Student s = new Student();
            s.id = id;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                // here coloumnindexOne is name because our query returning only one coloumn i.e name
                s.name = rs.getString(1);
            } else {
                return null; // No student found
            }

            rs.close();
            st.close();

            return s;
        } catch (Exception e) {
            System.out.println("❌ Query error: " + e);
        }

        return null;
    }
}

class Student {
    int id;
    String name;
}
