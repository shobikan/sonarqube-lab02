package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public void findUser(String username) throws SQLException {
        try (Connection conn = getConnection();
                PreparedStatement st = conn.prepareStatement(
                        "SELECT name FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        try (Connection conn = getConnection();
                PreparedStatement st = conn.prepareStatement(
                        "DELETE FROM users WHERE name = ?")) {
            st.setString(1, username);
            st.execute();
        }
    }

    private Connection getConnection() throws SQLException {
        String url = System.getenv("DB_URL");
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        if (isBlank(url) || isBlank(user) || isBlank(password)) {
            throw new SQLException("Database credentials are not configured");
        }

        return DriverManager.getConnection(url, user, password);
    }

    private boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}