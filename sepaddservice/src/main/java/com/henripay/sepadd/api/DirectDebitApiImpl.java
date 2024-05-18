package com.henripay.sepadd.api;

import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.controller.DirectDebitApiDelegate;
import com.henripay.sepadd.dto.DirectDebitRequest;
import com.henripay.sepadd.dto.TransactionResponse;
import com.henripay.sepadd.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@Slf4j
@RestController
public class DirectDebitApiImpl implements DirectDebitApiDelegate {

    private final TransactionService transactionService;

    public DirectDebitApiImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * POST /direct-debit : Add Direct Debit Transaction
     *
     * @param directDebitRequest Direct Debit Request (optional)
     * @return Successful transaction (status code 200)
     */
    @ApiOperation(value = "Add Direct Debit Transaction", nickname = "directDebitPost", response = TransactionResponse.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful transaction", response = TransactionResponse.class)})
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/direct-debit",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<TransactionResponse> directDebitPost(@ApiParam(value = "Direct Debit Request") @Valid @RequestBody(required = false) DirectDebitRequest directDebitRequest) {
        if(directDebitRequest.getAccountInfo() != null)
            log.info(directDebitRequest.getAccountInfo().getIBAN());

        TransactionResponse response;
        try {
            response = transactionService.addDirectDebitTransaction(directDebitRequest);
        } catch (FirebaseException | JacksonUtilityException | IOException e) {
            throw new RuntimeException(e);
        }
        response.setStatus(response.getStatus());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
