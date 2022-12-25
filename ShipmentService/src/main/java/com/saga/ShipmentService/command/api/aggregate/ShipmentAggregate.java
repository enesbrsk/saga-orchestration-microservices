package com.saga.ShipmentService.command.api.aggregate;

import com.saga.CommonService.commands.ShipOrderCommand;
import com.saga.CommonService.events.OrderShipmentEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ShipmentAggregate {

    @AggregateIdentifier
    private String shipmentId;
    private String orderId;
    private String shipmentStatus;

    public ShipmentAggregate(){

    }


    @CommandHandler
    public ShipmentAggregate(ShipOrderCommand shipOrderCommand){

        //validate the command
        //publish the order shipped event

        OrderShipmentEvent orderShipmentEvent
                = OrderShipmentEvent.builder()
                .shipmentId(shipOrderCommand.getShipmentId())
                .orderId(shipOrderCommand.getOrderId())
                .shipmentStatus("COMPLETED")
                .build();

        AggregateLifecycle.apply(orderShipmentEvent);
    }

    @EventSourcingHandler
    public void on(OrderShipmentEvent event){
        this.orderId = event.getOrderId();
        this.shipmentId = event.getShipmentId();
        this.shipmentStatus = event.getShipmentStatus();
    }

}
