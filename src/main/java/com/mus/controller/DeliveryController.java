package com.mus.controller;

import com.mus.model.DAO.interfaces.GeneralDao;
import com.mus.model.DAO.DeliveryDao;
import com.mus.model.models.Delivery;

import java.util.Objects;

public class DeliveryController implements com.mus.controller.interfaces.DeliveryController {

    private GeneralDao<Delivery, Integer> deliveryDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s | %-20s | %-20s | %-20s |","id","worker_id","price","type","maxWeight","minWeight");
    }

    @Override
    public GeneralDao<Delivery, Integer> generalDao() {
        return Objects.requireNonNullElseGet(deliveryDao, () -> deliveryDao = new DeliveryDao());
    }
}
