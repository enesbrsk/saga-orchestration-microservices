package com.saga.PaymentService.command.api.aggregate;

import com.saga.CommonService.commands.ValidatePaymentCommand;
import com.saga.CommonService.events.PaymentProcessedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@Slf4j
public class PaymentAggregate {

    @AggregateIdentifier
    private String paymentId;
    private String orderId;
    private String paymentStatus;

    public PaymentAggregate() {
    }

    @CommandHandler
    public PaymentAggregate(ValidatePaymentCommand validatePaymentCommand) {
        //validate the payment details
        //publish the payment processed event

      log.info("Executing ValidatePaymentCommand for " + "Order Id: {} and Payment Id: {}",
              validatePaymentCommand.getOrderId(),validatePaymentCommand.getPaymentId());

        PaymentProcessedEvent paymentProcessedEvent
                = new PaymentProcessedEvent(validatePaymentCommand.getPaymentId(),validatePaymentCommand.getOrderId());

        AggregateLifecycle.apply(paymentProcessedEvent);

        log.info("PaymentProcessedEvent Applied");
    }

    @EventSourcingHandler
    public void on(PaymentProcessedEvent event){
        this.paymentId = event.getPaymentId();;
        this.orderId = event.getOrderId();
    }
}
