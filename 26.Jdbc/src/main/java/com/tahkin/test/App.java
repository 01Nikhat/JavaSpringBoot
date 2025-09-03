package com.tahkin.test;
// This is the package declaration (defines the namespace for your class)

import java.sql.Connection;   // Importing Connection interface for connecting to the database
import java.sql.DriverManager; // DriverManager is used to create database connections
import java.sql.ResultSet;     // ResultSet is used to store and access the results of SQL queries
import java.sql.Statement;     // Statement is used to send SQL queries to the database

/**
 * This program connects to a MySQL database using JDBC
 * and retrieves a student's name based on their ID.
 *
 * In Maven projects:
 * - You don’t need to manually add jar files.
 * - Adding dependency in `pom.xml` automatically downloads MySQL connector.
 */
public class App {
    public static void main(String[] args) throws Exception {

        // Database URL format: jdbc:mysql://hostname:port/databaseName
        String url = "jdbc:mysql://localhost:3306/employees";

        // Username and password for MySQL database
        String uname = "root";
        String pass = "";

        // SQL query: selects "name" column from "students" table where id = 101
        String query = "SELECT name FROM students WHERE id = 101;";

        // Establish a connection to the database
        Connection con = DriverManager.getConnection(url, uname, pass);

        // Create a Statement object to execute queries
        Statement st = con.createStatement();

        // Execute the query and store the result in ResultSet
        ResultSet rs = st.executeQuery(query);

        // Move the cursor to the first row in ResultSet
        rs.next();

        // Get the value of the "name" column from the current row
        String name = rs.getString("name");

        // Print the retrieved name on the console
        System.out.println(name);

        // Close the statement and release resources
        st.close();

        // NOTE: Always good practice to close connection too
        con.close();
    }
}
