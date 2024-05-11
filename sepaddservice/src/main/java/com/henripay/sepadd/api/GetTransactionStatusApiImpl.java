package com.henripay.sepadd.api;

import com.henripay.sepadd.controller.GetTransactionStatusApiDelegate;
import com.henripay.sepadd.dto.TransactionStatusResponse;
import com.henripay.sepadd.service.TransactionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@Service
@RestController
public class GetTransactionStatusApiImpl implements GetTransactionStatusApiDelegate {


    private final TransactionService transactionService;

    public GetTransactionStatusApiImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * GET /getTransactionStatus : Get Transaction Status
     *
     * @param transactionId ID of the transaction (required)
     * @return Transaction status retrieved successfully (status code 200)
     */
    @ApiOperation(value = "Get Transaction Status", nickname = "getTransactionStatusGet", response = TransactionStatusResponse.class, tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transaction status retrieved successfully", response = TransactionStatusResponse.class)})
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/get-transaction-status",
            produces = {"application/json"}
    )
    public ResponseEntity<TransactionStatusResponse> getTransactionStatusGet(@NotNull @ApiParam(value = "ID of the transaction", required = true) @Valid @RequestParam(value = "transactionId") String transactionId) {
        TransactionStatusResponse status = transactionService.queryTransactionByTransactionId(transactionId);

        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}
