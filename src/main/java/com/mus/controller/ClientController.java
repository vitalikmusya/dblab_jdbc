package com.mus.controller;

import com.mus.model.DAO.ClientDao;
import com.mus.model.models.Client;
import com.mus.model.DAO.interfaces.GeneralDao;

import java.util.Objects;

public class ClientController implements com.mus.controller.interfaces.ClientController {

    private GeneralDao<Client, Integer> clientDao;

    @Override
    public String printColumns(){
        return String.format("|%3s| %-20s | %-20s |","id","phoneNumberFormal","phoneNumberStandart");
    }

    @Override
    public GeneralDao<Client, Integer> generalDao() {
        return Objects.requireNonNullElseGet(clientDao, () -> clientDao = new ClientDao());
    }

}
