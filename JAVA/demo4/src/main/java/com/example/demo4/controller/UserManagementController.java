package com.example.demo4.controller;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.model.User;
import com.example.demo4.service.UserService;
import com.example.demo4.util.NavigationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class UserManagementController {

    @FXML public TableView<User> usersTable;
    @FXML public TableColumn<User, Integer> userIdColumn;
    @FXML public TableColumn<User, String> usernameColumn;
    @FXML public TableColumn<User, String> passwordColumn;
    @FXML public TableColumn<User, String> emailColumn;
    @FXML public TableColumn<User, String> roleColumn;
    @FXML public TableColumn<User, String> contactNumberColumn;
    @FXML public TextField usernameField, passwordField, emailField, roleField, contactNumberField, searchField;
    @FXML public Button back;

    private UserService userService;

    public UserManagementController() {
        userService = new UserService(DatabaseConnection.getConnection());
    }

    @FXML
    private void initialize() {
        setupTableColumns();
        loadUsers();
    }

    private void setupTableColumns() {
        userIdColumn.setCellValueFactory(new PropertyValueFactory<>("userId"));
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
    }

    private void loadUsers() {
        try {
            ObservableList<User> users = FXCollections.observableArrayList(userService.getAllUsers());
            usersTable.setItems(users);
        } catch (SQLException ex) {
            showAlert("Error loading users", ex.getMessage());
        }
    }

    @FXML
    private void handleAddUser() {
        try {
            User newUser = new User(0, usernameField.getText(), passwordField.getText(), emailField.getText(), roleField.getText(), contactNumberField.getText());
            if (userService.addUser(newUser)) {
                loadUsers(); // Refresh the user list
                showAlert("Success", "User added successfully.");
            } else {
                showAlert("Validation Error", "Please fill all fields correctly.");
            }
        } catch (SQLException ex) {
            showAlert("Error adding user", ex.getMessage());
        }
    }

    @FXML
    private void handleUpdateUser() {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            selectedUser.setUsername(usernameField.getText());
            selectedUser.setPassword(passwordField.getText());
            selectedUser.setEmail(emailField.getText());
            selectedUser.setRole(roleField.getText());
            selectedUser.setContactNumber(contactNumberField.getText());
            try {
                if (userService.updateUser(selectedUser)) {
                    loadUsers(); // Refresh the user list
                    showAlert("Success", "User updated successfully.");
                } else {
                    showAlert("Validation Error", "Please fill all fields correctly.");
                }
            } catch (SQLException ex) {
                showAlert("Error updating user", ex.getMessage());
            }
        } else {
            showAlert("No user selected", "Please select a user from the table.");
        }
    }

    @FXML
    private void handleDeleteUser() {
        User selectedUser = usersTable.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            try {
                userService.deleteUser(selectedUser.getUserId());
                loadUsers(); // Refresh the user list
                showAlert("Success", "User deleted successfully.");
            } catch (SQLException ex) {
                showAlert("Error deleting user", ex.getMessage());
            }
        } else {
            showAlert("No user selected", "Please select a user from the table.");
        }
    }

    @FXML
    private void handleSearch() {
        try {
            ObservableList<User> users = FXCollections.observableArrayList(userService.searchUsersByUsername(searchField.getText()));
            usersTable.setItems(users);
        } catch (SQLException ex) {
            showAlert("Search error", "Failed to search users.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    private void Goback() throws Exception {
        NavigationUtil.changeScene(back, "/com/example/demo4/admin_dashboard.fxml");
    }
}
