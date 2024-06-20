package com.example.demo4.service;

import com.example.demo4.dao.PaymentDAO;
import com.example.demo4.model.Payment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentService {
    private PaymentDAO paymentDAO;

    public PaymentService(Connection connection) {
        this.paymentDAO = new PaymentDAO(connection);
    }

    public List<Payment> getAllPayments() throws SQLException {
        return paymentDAO.getAllPayments();
    }

    public List<Payment> filterPaymentsByStatus(String status) throws SQLException {
        return getAllPayments().stream()
                .filter(payment -> payment.getPaymentStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}
