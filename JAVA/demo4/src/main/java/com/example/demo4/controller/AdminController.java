package com.example.demo4.controller;

import com.example.demo4.util.NavigationUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminController {


    @FXML
    private Button logoutButton;
    @FXML
    private Button manageUsersButton;  // Add @FXML to ensure proper injection
    @FXML
    private Button manageInventoryButton;  // Add @FXML to ensure proper injection
    @FXML
    private Button processPaymentsButton;  // Add @FXML to ensure proper injection

    @FXML
    private Node anyFxIdNode;  // Replace 'anyFxIdNode' with an actual fx:id

    @FXML
    private void handleManageUsers() throws IOException {
        loadScreen("/com/example/demo4/user_management.fxml");
    }

    @FXML
    private void handleManageInventory() throws IOException {
        loadScreen("/com/example/demo4/inventory_management.fxml");
    }

    @FXML
    private void handlePaymentProcessing() throws IOException {
        loadScreen("/com/example/demo4/payment_processing.fxml");
    }
    @FXML
    private void handleLogout() throws Exception {
        NavigationUtil.changeScene(logoutButton, "/com/example/demo4/main.fxml");
    }


    // Method to load new screens
    private void loadScreen(String fxmlPath) throws IOException {
        if (manageUsersButton == null) {
            System.out.println("trackParcelsButton is null");  // For debugging purposes
            return;
        }
        Stage stage = (Stage) manageUsersButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        stage.setScene(new Scene(root));
        stage.show();
    }



}
