package com.example.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;

import java.util.List;

public interface PaymentApi {
    @Tag( name = "Payment", description = "Obtain the info for payment service")
    @Operation(
            summary = "Payment result",
            description = "Validate the info for payment"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200", description = "Successful"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "${api.responseCodes.internalServer.description}",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = ErrorResponse.class))
                            }
                    ),
            }
    )
    ResponseEntity<String> processPayment( PaymentRequest paymentRequest );

}


