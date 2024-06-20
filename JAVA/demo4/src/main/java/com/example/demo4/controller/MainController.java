package com.example.demo4.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {

    public Button adminButton;
    public Button customerButton;

    @FXML
    private void handleAdminLogin() throws IOException {
        // Load the Admin Dashboard view
        Stage stage = (Stage) adminButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo4/admin_dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void handleCustomerLogin() throws IOException {
        // Load the Customer Dashboard view
        Stage stage = (Stage) customerButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo4/customer_dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
