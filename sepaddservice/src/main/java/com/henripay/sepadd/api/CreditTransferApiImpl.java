package com.henripay.sepadd.api;

import com.henripay.common.firebase4j.error.FirebaseException;
import com.henripay.common.firebase4j.error.JacksonUtilityException;
import com.henripay.sepadd.controller.CreditTransferApiDelegate;
import com.henripay.sepadd.dto.CreditTransferRequest;
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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@Service
@RestController
public class CreditTransferApiImpl implements CreditTransferApiDelegate {

    Logger logger = LoggerFactory.getLogger(CreditTransferApiImpl.class);
    @Autowired
    private TransactionService transactionService;

    @Autowired
    public void GetTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;

    }

    /**
     * POST /creditTransfer : Add Credit Transfer Transaction
     *
     * @param creditTransferRequest Credit Transfer Request (optional)
     * @return Successful transaction (status code 200)
     */
    @ApiOperation(value = "Add Credit Transfer Transaction", nickname = "creditTransferPost", notes = "", response = TransactionResponse.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful transaction", response = TransactionResponse.class)})
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/credit-transfer",
            produces = {"application/json"},
            consumes = {"application/json"}
    )
    public ResponseEntity<TransactionResponse> creditTransferPost(@ApiParam(value = "Credit Transfer Request") @Valid @RequestBody(required = false) CreditTransferRequest creditTransferRequest) {
        logger.info(creditTransferRequest.getAccountInfo().getIBAN());

        TransactionResponse response;
        try {
            response = transactionService.addCreditTransferTransaction(creditTransferRequest);
        } catch (JacksonUtilityException | FirebaseException | IOException e) {
            throw new RuntimeException(e);
        }
        response.setStatus(response.getStatus());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}


