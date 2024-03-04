package com.henripay.sepadd.api;

import com.henripay.sepadd.api.model.DirectDebitRequest;

import com.henripay.sepadd.api.model.TransactionResponse;
import com.henripay.sepadd.service.TransactionService;
import io.swagger.annotations.*;
import net.thegreshams.firebase4j.error.FirebaseException;
import net.thegreshams.firebase4j.error.JacksonUtilityException;
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
public class DirectDebitApiImpl implements DirectDebitApi {

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
        logger.info(directDebitRequest.getAccountInfo().getIBAN());

        TransactionResponse response = new TransactionResponse();
        try {
            response = transactionService.addDirectDebitTransaction(directDebitRequest);
        } catch (JacksonUtilityException e) {
            throw new RuntimeException(e);
        } catch (FirebaseException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setStatus(response.getStatus());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
