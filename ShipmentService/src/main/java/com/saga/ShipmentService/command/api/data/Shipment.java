package com.saga.ShipmentService.command.api.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shipment {

    @Id
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;

}
