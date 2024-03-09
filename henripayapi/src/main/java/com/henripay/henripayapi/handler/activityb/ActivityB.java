package com.henripay.henripayapi.handler.activityb;

import java.util.logging.Logger;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityB implements JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		log.info("Running Activity B");
		Thread.sleep(5000);
		log.info("After 5 seconds inside Activity B");
	}

}
