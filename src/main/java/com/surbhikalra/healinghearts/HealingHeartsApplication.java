package com.surbhikalra.healinghearts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HealingHeartsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealingHeartsApplication.class, args);
    }

}
