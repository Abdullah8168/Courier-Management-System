package com.example.demo4.model;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Payment {
    private IntegerProperty paymentId = new SimpleIntegerProperty();
    private DoubleProperty amount = new SimpleDoubleProperty();
    private StringProperty paymentStatus = new SimpleStringProperty();
    private StringProperty paymentMethod = new SimpleStringProperty();
    private ObjectProperty<LocalDate> paymentDate = new SimpleObjectProperty<>();

    public Payment(int paymentId, double amount, String paymentStatus, String paymentMethod, LocalDate paymentDate) {
        this.paymentId.set(paymentId);
        this.amount.set(amount);
        this.paymentStatus.set(paymentStatus);
        this.paymentMethod.set(paymentMethod);
        this.paymentDate.set(paymentDate);
    }

    // Getters and setters, properties
    public int getPaymentId() {
        return paymentId.get();
    }

    public void setPaymentId(int paymentId) {
        this.paymentId.set(paymentId);
    }

    public double getAmount() {
        return amount.get();
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }

    public String getPaymentStatus() {
        return paymentStatus.get();
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus.set(paymentStatus);
    }

    public String getPaymentMethod() {
        return paymentMethod.get();
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod.set(paymentMethod);
    }

    public LocalDate getPaymentDate() {
        return paymentDate.get();
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate.set(paymentDate);
    }
}
