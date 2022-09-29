package com.sms.utility;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

    public static Connection provideConnection(String dbName) {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.getMessage();
        }

        String url = "jdbc:mysql://localhost:3306/" + dbName;

        try {
            conn = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        return conn;

    }

}
