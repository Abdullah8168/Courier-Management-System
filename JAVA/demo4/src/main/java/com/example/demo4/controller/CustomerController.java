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

public class CustomerController {

    public Button trackParcelsButton;
    public Button supportButton;
    public Button feedbackButton;
    public Button logoutButton;
    @FXML
    private Node anyFxIdNode;  // Replace 'anyFxIdNode' with an actual fx:id

    @FXML
    private void handleTrackParcels() throws IOException {
        loadScreen("/com/example/demo4/parcel_tracking.fxml");
    }

    @FXML
    private void handleCustomerSupport() throws IOException {
        loadScreen("/com/example/demo4/support_ticket.fxml");
    }

    @FXML
    private void handleGiveFeedback() throws IOException {
        loadScreen("/com/example/demo4/feedback.fxml");
    }

    @FXML
    private void handleLogout() throws Exception {
        NavigationUtil.changeScene(logoutButton, "/com/example/demo4/main.fxml");
    }
    
    private void loadScreen(String fxmlPath) throws IOException {
        if (trackParcelsButton == null) {
            System.out.println("trackParcelsButton is null");  // For debugging purposes
            return;
        }
        Stage stage = (Stage) trackParcelsButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
