package com.example.demo4.service;

import com.example.demo4.dao.UserDAO;
import com.example.demo4.model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private UserDAO userDAO;

    public UserService(Connection connection) {
        this.userDAO = new UserDAO(connection);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDAO.getAllUsers();
    }

    public boolean addUser(User user) throws SQLException {
        if (validateUser(user)) {
            userDAO.addUser(user);
            return true;
        }
        return false;
    }

    public boolean updateUser(User user) throws SQLException {
        if (validateUser(user) && user.getUserId() > 0) {
            userDAO.updateUser(user);
            return true;
        }
        return false;
    }

    public void deleteUser(int userId) throws SQLException {
        userDAO.deleteUser(userId);
    }

    public List<User> searchUsersByUsername(String username) throws SQLException {
        return getAllUsers().stream()
                .filter(user -> user.getUsername().toLowerCase().contains(username.toLowerCase()))
                .collect(Collectors.toList());
    }

    private boolean validateUser(User user) {
        return !user.getUsername().isEmpty() && !user.getPassword().isEmpty() &&
                !user.getEmail().isEmpty() && !user.getRole().isEmpty() &&
                !user.getContactNumber().isEmpty();
    }
}
