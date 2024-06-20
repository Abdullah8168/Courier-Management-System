package com.example.demo4.controller;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.model.Payment;
import com.example.demo4.service.PaymentService;
import com.example.demo4.util.NavigationUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;

public class PaymentProcessingController {
    @FXML private TableView<Payment> paymentsTable;
    @FXML private ComboBox<String> filterStatusComboBox;
    @FXML private Button back;

    private PaymentService paymentService;

    public PaymentProcessingController() {
        paymentService = new PaymentService(DatabaseConnection.getConnection());
    }

    @FXML
    private void initialize() {
        try {
            ObservableList<Payment> payments = FXCollections.observableArrayList(paymentService.getAllPayments());
            paymentsTable.setItems(payments);
        } catch (SQLException ex) {
            showAlert("Error loading payments", ex.getMessage());
        }
    }

    @FXML
    private void handleFilterByStatus() {
        String selectedStatus = filterStatusComboBox.getValue();
        if (selectedStatus != null) {
            try {
                ObservableList<Payment> filteredPayments = FXCollections.observableArrayList(paymentService.filterPaymentsByStatus(selectedStatus));
                paymentsTable.setItems(filteredPayments);
            } catch (SQLException ex) {
                showAlert("Error filtering payments", ex.getMessage());
            }
        }
    }

    @FXML
    private void Goback() throws Exception {
        NavigationUtil.changeScene(back, "/com/example/demo4/admin_dashboard.fxml");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
