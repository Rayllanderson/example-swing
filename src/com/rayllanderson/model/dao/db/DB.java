package com.rayllanderson.model.dao.db;

import com.rayllanderson.model.dao.exceptions.DbException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                String url = "jdbc:postgresql://localhost:5432/swing_example";
                String user = "postgres";
                String password = "12345";
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("The database has been successfully connected");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
