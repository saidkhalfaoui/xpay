package com.henripay.customerservice.tests;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("ABD")
@Component
public class TestDataRunner implements CommandLineRunner {
    private final TestDataService testDataService;

    public TestDataRunner(TestDataService testDataService) {
        this.testDataService = testDataService;
    }

    @Override
    public void run(String... args) throws Exception {
        testDataService.saveData();
        testDataService.printAllData();
    }
}
