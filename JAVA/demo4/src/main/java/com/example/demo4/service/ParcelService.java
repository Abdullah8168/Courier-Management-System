package com.example.demo4.service;

import com.example.demo4.dao.ParcelDAO;
import com.example.demo4.model.Parcel;
import java.sql.Connection;
import java.util.List;

public class ParcelService {
    private ParcelDAO parcelDAO;

    public ParcelService(Connection connection) {
        this.parcelDAO = new ParcelDAO(connection);
    }

    public List<Parcel> getParcelsByUserId(int userId) {
        return parcelDAO.getParcelsByUserId(userId);
    }

    public List<Parcel> searchParcels(String criteria) {
        return parcelDAO.searchParcels(criteria);
    }

    public void updateParcelStatus(int parcelId, String newStatus) {
        parcelDAO.updateParcelStatus(parcelId, newStatus);
    }
}
