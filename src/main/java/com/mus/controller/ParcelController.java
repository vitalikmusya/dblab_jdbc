package com.mus.controller;

import com.mus.model.DAO.interfaces.GeneralDao;
import com.mus.model.DAO.ParcelDao;
import com.mus.model.models.Parcel;

import java.util.Objects;

public class ParcelController implements com.mus.controller.interfaces.ParcelController {

    private GeneralDao<Parcel, Integer> parcelDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s | %-40s | %-40s |",
                "id",
                "price",
                "weight",
                "dateSend",
                "dateRecive",
                "addressSender",
                "addressReciver");
    }

    @Override
    public GeneralDao<Parcel, Integer> generalDao() {
        return Objects.requireNonNullElseGet(parcelDao, () -> parcelDao = new ParcelDao());
    }
}
