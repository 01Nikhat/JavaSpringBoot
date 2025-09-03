package com.tahkin.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insertDynamic {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/employees";
        // MySQL database username and password
        String uname = "nikhat";       // your DB username
        String pass = "Nikhat@7687";   // your DB password

        int userId = 107;
        String userNmae = "Arfa";
        String city = "Kolkata";

        String query = "insert into students values (?,?,?)";

        // Establish connection with MySQL using DriverManager
        Connection con = DriverManager.getConnection(url, uname, pass);

        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1,userId);
        st.setString(2,userNmae);
        st.setString(3,city);

        int count = st.executeUpdate();

        System.out.println(count + "row/s affected ");

        st.close();
        con.close();

    }
}
