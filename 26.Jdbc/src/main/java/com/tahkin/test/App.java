package com.tahkin.test;
// Package declaration (defines the namespace for this class)

// Importing required JDBC classes
import java.sql.Connection;   // Connection object is used to connect Java app with DB
import java.sql.DriverManager; // DriverManager helps to establish a DB connection
import java.sql.ResultSet;     // ResultSet holds the data retrieved from SQL queries
import java.sql.Statement;     // Statement is used to send SQL queries to DB

/**
 * JDBC Example Program:
 * ---------------------
 * - Connects to a MySQL database
 * - Executes a query on the "students" table
 * - Retrieves and prints all student records (id, name, city)
 *
 * Note:
 * In Maven projects, you don’t need to manually add JAR files.
 * Just add MySQL connector dependency in pom.xml.
 */
public class App {
    public static void main(String[] args) throws Exception {

        // Database URL format: jdbc:mysql://hostname:port/databaseName
        // "employees" is the database name
        String url = "jdbc:mysql://localhost:3306/employees";

        // MySQL database username and password
        String uname = "root";       // your DB username
        String pass = "";   // your DB password

        // SQL query: fetch all columns from the "students" table
        String query = "SELECT * FROM students";

        // Establish connection with MySQL using DriverManager
        Connection con = DriverManager.getConnection(url, uname, pass);

        // Create a Statement object to execute queries
        Statement st = con.createStatement();

        // Execute the query and store results inside ResultSet
        ResultSet rs = st.executeQuery(query);

        // Loop through the ResultSet (row by row)
        while (rs.next()) {
            // Fetch values from each column
            // Indexes: 1 = id, 2 = name, 3 = city
            int id = rs.getInt(1);       // get "id" column (1st column)
            String name = rs.getString(2); // get "name" column (2nd column)
            String city = rs.getString(3); // get "city" column (3rd column)

            // Print the student record
            System.out.println(id + " : " + name + " : " + city);
        }

        // Close the statement to release resources
        st.close();

        // Close the connection to free database resources
        con.close();

        // NOTE: Calling con.close() twice is not necessary, once is enough
    }
}
