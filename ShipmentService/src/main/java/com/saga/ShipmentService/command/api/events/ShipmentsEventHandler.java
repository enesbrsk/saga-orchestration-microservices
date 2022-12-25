package com.saga.ShipmentService.command.api.events;

import com.saga.CommonService.events.OrderShipmentEvent;
import com.saga.ShipmentService.command.api.data.Shipment;
import com.saga.ShipmentService.command.api.repository.ShipmentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ShipmentsEventHandler {

    private ShipmentRepository shipmentRepository;

    public ShipmentsEventHandler(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @EventHandler
    public void on(OrderShipmentEvent event){

        Shipment shipment
                = new Shipment();
        BeanUtils.copyProperties(event,shipment);
        shipmentRepository.save(shipment);

    }
}
