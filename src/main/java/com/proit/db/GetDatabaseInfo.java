package com.proit.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetDatabaseInfo {

    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL
                    = "jdbc:sqlserver://localhost;user=udemy;password=123;databaseName=UdemyDemoDM;encrypt=true;trustServerCertificate=true;";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData meta = conn.getMetaData();

                System.out.println("Driver name: " + meta.getDriverName());
                System.out.println("Driver vision: " + meta.getDriverVersion());
                System.out.println("Username :" + meta.getUserName());
                System.out.println("URL: " + meta.getURL());
                System.out.println("Database Name: " + meta.getDatabaseProductName());
                System.out.println("Database version: " + meta.getDatabaseProductVersion());
                ResultSet rs = meta.getTables(null, null, "first", null);

                while (rs.next()) {
                    System.out.println("Table name: " + rs.getString("TABLE_NAME"));
                    System.out.println("Table type: " + rs.getString("TABLE_TYPE"));
                    System.out.println("Table scheme: " + rs.getString("TABLE_SCHEM"));
                    System.out.println("Table catalog: " + rs.getString("TABLE_CAT"));

                }
            }

            System.out.println("successfully");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
