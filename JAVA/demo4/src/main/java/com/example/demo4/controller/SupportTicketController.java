package com.example.demo4.controller;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.dao.SupportTicketDAO;
import com.example.demo4.model.SupportTicket;
import com.example.demo4.service.SupportTicketService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.sql.Connection;
import java.sql.Date;
import com.example.demo4.util.NavigationUtil;
import javafx.scene.control.*;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SupportTicketController {
    public Button back;
    @FXML
    private TableView<SupportTicket> ticketTable;
    @FXML
    private TableColumn<SupportTicket, Integer> ticketIdColumn;
    @FXML
    private TableColumn<SupportTicket, String> subjectColumn;
    @FXML
    private TableColumn<SupportTicket, String> statusColumn;
    @FXML
    private TableColumn<SupportTicket, Date> createdAtColumn;
    @FXML
    private TableColumn<SupportTicket, Date> updatedAtColumn;
    @FXML private TextField commentField;
    @FXML private Button updateButton, backButton;
    private final SupportTicketDAO supportTicketDAO;
    private SupportTicketService supportTicketService = new SupportTicketService();

    public SupportTicketController() {
        Connection connection = DatabaseConnection.getConnection();
        this.supportTicketDAO = new SupportTicketDAO(connection);
    }


    @FXML
    public void initialize() {
        try {
            ObservableList<SupportTicket> tickets = FXCollections.observableArrayList(supportTicketDAO.getTicketsByUserId(1));
            if (tickets.isEmpty()) {
                System.out.println("No tickets found for user ID 1.");
            } else {
                ticketTable.setItems(tickets);
                System.out.println(tickets.size() + " tickets loaded.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading tickets: " + e.getMessage());
        }
    }


    private void loadTickets() {
        ObservableList<SupportTicket> tickets = supportTicketService.getTicketsByUserId(1);
        ticketTable.setItems(tickets);
    }
    @FXML
    private void Goback() throws Exception {
        NavigationUtil.changeScene(back, "/com/example/demo4/customer_dashboard.fxml");
    }
    @FXML
    private void handleSubmitNewTicket() {
        // Open a dialog or new window to submit a new ticket
    }
    @FXML
    private void handleUpdateTicket() {
        SupportTicket selected = ticketTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            supportTicketService.updateTicketStatus(selected.getTicketId(), "Updated", commentField.getText());
            loadTickets();
        }
    }

    @FXML
    private void handleBack() throws Exception {
        NavigationUtil.changeScene(backButton, "/com/example/demo4/customer_dashboard.fxml");
    }
}
