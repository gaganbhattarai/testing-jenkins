package com.gritfeat.botpoc.botpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class BotPocApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotPocApplication.class, args);
    }

}
