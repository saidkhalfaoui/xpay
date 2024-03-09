package com.henripay.henripayapi.handler.activitya;


import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RollbackActivityA implements JavaDelegate {

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		log.info("Rollback Activity A");
	}

}
