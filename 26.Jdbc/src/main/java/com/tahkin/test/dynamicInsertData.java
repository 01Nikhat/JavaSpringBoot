package com.tahkin.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dynamicInsertData {
    public static void main(String[] args) throws Exception {
        StudentDataAdd obj = new StudentDataAdd();

        obj.connect();

        Students s1 = new Students();
        s1.id = 109;
        s1.name = "Naheed";
        s1.city = "Odisha";
        obj.addStudent(s1);



    }
}

class StudentDataAdd{

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
    public void addStudent(Students s){
        String query = "insert into students values (?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,s.id);
            pst.setString(2,s.name);
            pst.setString(3,s.city);

            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

class Students{
    int id;
    String name;
    String city;
}