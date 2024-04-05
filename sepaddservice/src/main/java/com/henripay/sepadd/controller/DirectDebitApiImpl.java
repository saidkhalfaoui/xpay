package com.henripay.sepadd.controller;

import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.dto.DirectDebitRequest;
import com.henripay.sepadd.dto.TransactionResponse;
import com.henripay.sepadd.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

@RestController
public class DirectDebitApiImpl implements DirectDebitApiDelegate {

    Logger logger = LoggerFactory.getLogger(DirectDebitApiImpl.class);
    @Autowired
    private TransactionService transactionService;

    @Autowired
    public void GetTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;

    }


    /**
     * POST /direct-debit : Add Direct Debit Transaction
     *
     * @param directDebitRequest Direct Debit Request (optional)
     * @return Successful transaction (status code 200)
     */
    @ApiOperation(value = "Add Direct Debit Transaction", nickname = "directDebitPost", notes = "", response = TransactionResponse.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful transaction", response = TransactionResponse.class)})
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/direct-debit",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<TransactionResponse> directDebitPost(@ApiParam(value = "Direct Debit Request") @Valid @RequestBody(required = false) DirectDebitRequest directDebitRequest) {
        logger.info(directDebitRequest.getMetaData());

        TransactionResponse response = new TransactionResponse();
        try {
            response = transactionService.addDirectDebitTransaction(directDebitRequest);
        } catch (JacksonUtilityException | FirebaseException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setStatus(response.getStatus());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
