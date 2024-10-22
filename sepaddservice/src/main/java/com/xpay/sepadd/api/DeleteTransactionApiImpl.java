package com.xpay.sepadd.api;

import com.xpay.sepadd.dto.TransactionStatusResponse;
import com.xpay.sepadd.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@RestController
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-12-10T14:10:08.070140200+01:00[Europe/Amsterdam]")
@Validated
@Tag(name = "deleteTransaction", description = "the deleteTransaction API")
public class DeleteTransactionApiImpl {

    private final TransactionService transactionService;

    public DeleteTransactionApiImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * DELETE /deleteTransaction : (logical) delete Transaction
     *
     * @param transactionId ID of the transaction (required)
     * @return Transaction status retrieved successfully (status code 200)
     */
    @Operation(
            operationId = "deleteTransactionDelete",
            summary = "(logical) delete Transaction",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Transaction status retrieved successfully", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionStatusResponse.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/delete-transaction",
            produces = {"application/json"}
    )
    public ResponseEntity<TransactionStatusResponse> deleteTransactionDelete(
            @NotNull @Parameter(name = "transactionId", description = "ID of the transaction", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "transactionId", required = true) String transactionId
    ) {
        TransactionStatusResponse response = transactionService.deleteTransaction(transactionId);  // to fix

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}


