package com.example.demo4.model;

import java.util.Date;

public class Parcel {
    private int parcelId;
    private String status;
    private String destination;
    private int senderId;
    private int receiverId;
    private Date dispatchDate;
    private Date arrivalDate;

    // Constructors
    public Parcel(int parcelId, String status, String destination, int senderId, int receiverId, Date dispatchDate, Date arrivalDate) {
        this.parcelId = parcelId;
        this.status = status;
        this.destination = destination;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.dispatchDate = dispatchDate;
        this.arrivalDate = arrivalDate;
    }

    // Getters and Setters
    public int getParcelId() {
        return parcelId;
    }

    public void setParcelId(int parcelId) {
        this.parcelId = parcelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public Date getDispatchDate() {
        return dispatchDate;
    }

    public void setDispatchDate(Date dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
