package com.xpay.xpayapi.controller.internal;

import com.xpay.xpayapi.service.CollectionService;
import com.xpay.xpayapi.service.CommandService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.MessageCorrelationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class SepaddController {



@Autowired
private CollectionService collectionService;



        public SepaddController(CommandService commandService) {

        }

        // start process example
        @PostMapping("/notification/{key}")
        public void processNotification(@PathVariable String key) {
               log.info("Received Notification on process " +key);
               collectionService.catchMessageEvent(key , "PROCESSED");
        }

}
