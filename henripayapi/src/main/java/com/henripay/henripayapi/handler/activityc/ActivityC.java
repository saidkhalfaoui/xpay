package com.henripay.henripayapi.handler.activityc;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ActivityC implements JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		log.info("Running Activity C");
		Thread.sleep(5000);
		log.info("After 5 seconds inside Activity C");
	}

}
