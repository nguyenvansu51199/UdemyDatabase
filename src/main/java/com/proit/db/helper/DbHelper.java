package com.proit.db.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    public static final String DB_NAME = "UdemyDemoDM";
    public static final String USERNAME = "udemy";
    public static final String PASSWORD = "123";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return getConnection(DB_NAME, USERNAME, PASSWORD);
    }

    public static Connection getConnection(String dbName, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String dbURL
                = "jdbc:sqlserver://localhost;databaseName=%s"
                + ";encrypt=true;trustServerCertificate=true;";
        Connection conn = DriverManager.getConnection(String.format(dbURL, dbName), username, password);

        return conn;

    }
}
