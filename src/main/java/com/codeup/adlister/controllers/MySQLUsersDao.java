package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) throws SQLException {
        User userReturn = null;
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.NO_GENERATED_KEYS);
        stmt.setString(1, username);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();
        while (rs.next()) {
            long id = rs.getLong(1);
            String userName = rs.getString(2);
            String email = rs.getString(3);
            String password = rs.getString(4);
            userReturn = new User(id, userName, email, password);
        }
        return userReturn;
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }


}


