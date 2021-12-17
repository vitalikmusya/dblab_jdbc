package org.mus.rest.dto;

import org.mus.rest.models.Client;

public class ClientDto {
    private Client client;

    public ClientDto(Client client) {
        this.client = client;
    }

    public Integer getId() {
        return client.getId();
    }

    public String getPhoneNumberStandart() {
        return client.getPhoneNumberStandart();
    }

    public String getPhoneNumberFormal() {
        return client.getPhoneNumberFormal();
    }
}
