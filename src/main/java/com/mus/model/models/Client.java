package com.mus.model.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="client", schema="nova_poshta")
@Data
public class Client extends GeneralModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic
    @Column(name = "phone_number_standart")
    private String phoneNumberStandart;
    @Basic
    @Column(name = "phone_number_formal")
    private String phoneNumberFormal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(phoneNumberStandart, client.phoneNumberStandart) && Objects.equals(phoneNumberFormal, client.phoneNumberFormal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, phoneNumberStandart, phoneNumberFormal);
    }

    @Override
    public String toString() {
        return String.format("|%3s| %-20s | %-20s |",id,phoneNumberFormal,phoneNumberStandart);
    }
}
