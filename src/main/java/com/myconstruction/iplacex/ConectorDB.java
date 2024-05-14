package com.myconstruction.iplacex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class ConectorDB {
    private static Connection connection = null;
    
    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {

                String dbUrl = "jdbc:mariadb://localhost:3306/myconstruccion";
                String dbUser = "fcanales";
                String dbPassword = "felipe123";
                Class.forName ("org.mariadb.jdbc.Driver");
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
