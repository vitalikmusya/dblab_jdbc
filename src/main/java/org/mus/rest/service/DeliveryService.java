package org.mus.rest.service;

import org.mus.rest.dao.DeliveryRepository;
import org.mus.rest.models.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

@Service
@ApplicationScope
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery addDelivery(final Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateDelivery(final Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public List<Delivery> getDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(final Integer id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    public void deleteDeliveryById(final Integer id) {
        deliveryRepository.deleteById(id);
    }
}
