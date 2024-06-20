package com.example.demo4.service;

import com.example.demo4.DatabaseConnection;
import com.example.demo4.dao.SupportTicketDAO;
import com.example.demo4.model.SupportTicket;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SupportTicketService {
    private SupportTicketDAO supportTicketDAO = new SupportTicketDAO(DatabaseConnection.getConnection());

    public ObservableList<SupportTicket> getTicketsByUserId(int userId) {
        return FXCollections.observableArrayList(supportTicketDAO.getTicketsByUserId(userId));
    }

    public void updateTicketStatus(int ticketId, String status, String comment) {
        supportTicketDAO.updateTicketStatus(ticketId, status, comment);
    }
}
