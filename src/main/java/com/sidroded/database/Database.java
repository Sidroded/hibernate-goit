package com.sidroded.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class Database {
    private static Database instance = null;
    private final String dbUrl;
    private final String dbUser;
    private final String dbPass;

    private Database() {
        dbUrl = "jdbc:mysql://127.0.0.1:3306/test_db";
        dbUser = "root";
        dbPass = "root";
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
