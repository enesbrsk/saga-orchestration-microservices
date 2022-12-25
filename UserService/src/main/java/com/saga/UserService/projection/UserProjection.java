package com.saga.UserService.projection;

import com.saga.CommonService.model.CardDetails;
import com.saga.CommonService.model.User;
import com.saga.CommonService.quaries.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler
    public User getUserPaymentDetails(GetUserPaymentDetailsQuery query){

        // actually from to db
        CardDetails cardDetails
                = CardDetails.builder()
                .name("Enes Birisik")
                .validUntilYear(2022)
                .validUntilMonth(01)
                .cardNumber("123456789")
                .cvv(111)
                .build();

        return User.builder()
                .userId(query.getUserId())
                .firstName("Enes")
                .lastName("Birisik")
                .cardDetails(cardDetails)
                .build();

    }
}
