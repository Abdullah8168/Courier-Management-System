package com.example.demo4.model;

import java.util.Date;

public class SupportTicket {
    private int ticketId;
    private int userId;
    private String subject;
    private String description;
    private String status;  // e.g., Open, Closed, Pending
    private Date createdAt;
    private Date updatedAt;

    // Constructors
    public SupportTicket(int ticketId, int userId, String subject, String description, String status, Date createdAt, Date updatedAt) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
