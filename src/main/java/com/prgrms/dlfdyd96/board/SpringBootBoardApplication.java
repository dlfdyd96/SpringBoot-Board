package com.prgrms.dlfdyd96.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringBootBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBoardApplication.class, args);
    }

}
