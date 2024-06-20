package com.example.demo4.model;

import javafx.beans.property.*;

public class User {
    private IntegerProperty userId = new SimpleIntegerProperty();
    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();
    private StringProperty role = new SimpleStringProperty();
    private StringProperty contactNumber = new SimpleStringProperty();

    public User(int userId, String username, String password, String email, String role, String contactNumber) {
        this.userId.set(userId);
        this.username.set(username);
        this.password.set(password);
        this.email.set(email);
        this.role.set(role);
        this.contactNumber.set(contactNumber);
    }

    public int getUserId() {
        return userId.get();
    }

    public IntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public String getContactNumber() {
        return contactNumber.get();
    }

    public StringProperty contactNumberProperty() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber.set(contactNumber);
    }
}
