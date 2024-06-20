package com.example.demo4.dao;

import com.example.demo4.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("role"),
                        rs.getString("contact_number")
                ));
            }
        }
        return users;
    }

    // Implement methods for add, update, and delete
    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO Users (username, password, email, role, contact_number) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getRole());
            statement.setString(5, user.getContactNumber());
            statement.executeUpdate();
        }
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE Users SET username = ?, password = ?, email = ?, role = ?, contact_number = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getRole());
            statement.setString(5, user.getContactNumber());
            statement.setInt(6, user.getUserId());
            statement.executeUpdate();
        }
    }

    public void deleteUser(int userId) throws SQLException {
        String sql = "DELETE FROM Users WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        }
    }
}
