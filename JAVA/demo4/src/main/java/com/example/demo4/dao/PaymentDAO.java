package com.example.demo4.dao;

import com.example.demo4.model.Payment;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Payment> getAllPayments() throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payments";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                payments.add(new Payment(
                        rs.getInt("payment_id"),
                        rs.getDouble("amount"),
                        rs.getString("payment_status"),
                        rs.getString("payment_method"),
                        rs.getDate("payment_date").toLocalDate() // Corrected column name
                ));
            }
        }
        return payments;
    }
}
