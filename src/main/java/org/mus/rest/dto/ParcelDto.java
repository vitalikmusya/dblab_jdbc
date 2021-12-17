package org.mus.rest.dto;

import org.mus.rest.models.Parcel;

import java.sql.Date;

public class ParcelDto {

    private Parcel parcel;

    public ParcelDto(Parcel parcel) {
        this.parcel = parcel;
    }

    public Integer getId() {
        return parcel.getId();
    }

    public Double getPrice() {
        return parcel.getPrice();
    }

    public Double getWeight() {
        return parcel.getWeight();
    }

    public Date getDateSend() {
        return parcel.getDateSend();
    }

    public Date getDateRecive() {
        return parcel.getDateRecive();
    }

    public String getAddressSender() {
        return parcel.getAddressSender();
    }

    public String getAddressReciver() {
        return parcel.getAddressReciver();
    }
}
