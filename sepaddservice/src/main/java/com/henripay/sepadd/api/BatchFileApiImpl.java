package com.henripay.sepadd.api;

import com.henripay.sepadd.dto.GenerateBatchFileResponse;
import com.henripay.sepadd.controller.DirectDebitBatchApiDelegate;
import com.henripay.sepadd.service.BatchFileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BatchFileApiImpl implements DirectDebitBatchApiDelegate {

    private final BatchFileService batchFileService;

    public BatchFileApiImpl(BatchFileService batchFileService) {
        this.batchFileService = batchFileService;
    }

    /**
     * POST /direct-debit-batch : Generate one Direct Debit Transactions batch file
     *
     * @return Batch file generation status (status code 200)
     */
    @PostMapping("/direct-debit-batch")
    public ResponseEntity<GenerateBatchFileResponse> directDebitBatchPost() {
        try {
            return ResponseEntity.ok(this.batchFileService.generateBatchFile());
        } catch (Exception e) {
            return null;
        }
    }


}
