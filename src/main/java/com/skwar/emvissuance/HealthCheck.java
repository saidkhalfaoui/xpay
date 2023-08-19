package com.skwar.emvissuance;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @RequestMapping("/health")
    @ResponseBody
    public String health() {
        return "I am healthy !";
    }
}
