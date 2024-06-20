package com.example.demo4.dao;

import com.example.demo4.model.SupportTicket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupportTicketDAO {
    private Connection connection;

    public SupportTicketDAO(Connection connection) {
        this.connection = connection;
    }

    public List<SupportTicket> getTicketsByUserId(int userId) {
        List<SupportTicket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM support_tickets WHERE user_id = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                SupportTicket ticket = new SupportTicket(
                        rs.getInt("ticket_id"),
                        rs.getInt("user_id"),
                        rs.getString("subject"),
                        rs.getString("description"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                );
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public void updateTicketStatus(int ticketId, String status, String comment) {
        String sql = "UPDATE support_tickets SET status = ?, description = CONCAT(description, ?) WHERE ticket_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, status);
            statement.setString(2, "\nComment: " + comment);
            statement.setInt(3, ticketId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Additional methods to add a new ticket, update, or close existing tickets
}
