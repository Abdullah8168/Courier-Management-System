package com.example.demo4.model;

import java.util.Date;

public class Feedback {
    private int feedbackId;
    private int userId;
    private int rating; // Rating scale 1-5
    private String comments;
    private Date createdAt;

    // Constructors
    public Feedback(int feedbackId, int userId, int rating, String comments, Date createdAt) {
        this.feedbackId = feedbackId;
        this.userId = userId;
        this.rating = rating;
        this.comments = comments;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
