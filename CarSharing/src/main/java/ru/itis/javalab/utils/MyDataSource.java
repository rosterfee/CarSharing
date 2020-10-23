package ru.itis.javalab.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDataSource {

    private String URL;
    private String user;
    private String password;

    public MyDataSource(String URL, String user, String password) {
        this.URL = URL;
        this.user = user;
        this.password = password;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, user, password);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}