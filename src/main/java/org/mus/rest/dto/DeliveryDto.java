package org.mus.rest.dto;

import org.mus.rest.models.Delivery;
import org.mus.rest.models.Type;
import org.mus.rest.models.Worker;

public class DeliveryDto {
    private Delivery delivery;

    public DeliveryDto(Delivery delivery) {
        this.delivery = delivery;
    }

    public Integer getId() {
        return delivery.getId();
    }

    public Worker getWorkerId() {
        return delivery.getWorkerId();
    }

    public Double getPrice() {
        return delivery.getPrice();
    }

    public Type getType() {
        return delivery.getType();
    }

    public Double getMaxWeight() {
        return delivery.getMaxWeight();
    }

    public Double getMinWeight() {
        return delivery.getMinWeight();
    }
}
