package com.henripay.customerservice;

import com.henripay.customerservice.tests.TestDataService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CutomerserviceApplicationTests {

    @Autowired
    private TestDataService testDataService;

    @Test
    public void testSaveAndPrintData() {
        // Save test data
        testDataService.saveData();

        // Print all saved data
        testDataService.printAllData();
    }

}
