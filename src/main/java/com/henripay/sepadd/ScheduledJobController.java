package com.henripay.sepadd;


import com.henripay.sepadd.api.model.JobStatus;
import com.henripay.sepadd.api.model.Statusenum;
import com.henripay.sepadd.jobs.CreditTransferJob;
import com.henripay.sepadd.jobs.DirectDebitJob;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/jobs")
public class ScheduledJobController {
    // running jobs here , jobs are triggered from Google Scheduler
@Autowired
private  DirectDebitJob directDebitJob;
@Autowired
private CreditTransferJob creditTransferJob;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    Logger logger = LoggerFactory.getLogger(ScheduledJobController.class);

    @ApiOperation(value = "start direct debit", nickname = "start direct", notes = "", response = JobStatus.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful transaction", response = JobStatus.class) })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/start-direct-debit-job",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<JobStatus> startDirectDebitJob() throws InterruptedException {
        JobStatus status= new JobStatus();
        try {
          Future<?> jobStatusFuture= executorService.submit(directDebitJob );
          jobStatusFuture.get(1, TimeUnit.MINUTES);
          logger.info("is Done :"  + jobStatusFuture.isDone());
          if (jobStatusFuture.isDone())
          {
              status.setStatus(Statusenum.COMPLETED);
          }
          if (jobStatusFuture.isCancelled())
          {
              status.setStatus(Statusenum.CANCELLED);
          }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }




        status.setStartDate(new Date());
        return new ResponseEntity<> (status, HttpStatus.OK);



    }


    @ApiOperation(value = "start credit transfer job", nickname = "start credit transfer", notes = "", response = JobStatus.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful transaction", response = JobStatus.class) })
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/start-credit-transfer-job",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<JobStatus> startCreditTransferJob() throws InterruptedException {
        JobStatus status= new JobStatus();
        try {
            Future<?> jobStatusFuture= executorService.submit(creditTransferJob );
            jobStatusFuture.get(1, TimeUnit.MINUTES);
            logger.info("is Done :"  + jobStatusFuture.isDone());
            if (jobStatusFuture.isDone())
            {
                status.setStatus(Statusenum.COMPLETED);
            }
            if (jobStatusFuture.isCancelled())
            {
                status.setStatus(Statusenum.CANCELLED);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }




        status.setStartDate(new Date());
        return new ResponseEntity<> (status, HttpStatus.OK);



    }


    @PostMapping("/startPaymentOrderJob")
    public JobStatus startPaymentOrdersJob()
    {
      return new JobStatus();

    }
}
