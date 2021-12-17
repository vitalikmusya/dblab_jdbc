package com.mus.controller;

import com.mus.model.DAO.interfaces.GeneralDao;
import com.mus.model.DAO.IndentDao;
import com.mus.model.models.Indent;

import java.util.Objects;

public class IndentController implements com.mus.controller.interfaces.IndentController {

    private GeneralDao<Indent, Integer> indentDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-49s | %-51s | %-99s |","id","status","clientBySenderId","clientByReciverId","deliveryByDeliveryId");
    }

    @Override
    public GeneralDao<Indent, Integer> generalDao() {
        return Objects.requireNonNullElseGet(indentDao, () -> indentDao = new IndentDao());
    }
}
