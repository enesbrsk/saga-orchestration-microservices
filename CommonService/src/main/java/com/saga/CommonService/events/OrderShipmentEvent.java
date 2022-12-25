package com.saga.CommonService.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderShipmentEvent {

    private String shipmentId;
    private String orderId;
    private String shipmentStatus;

}
