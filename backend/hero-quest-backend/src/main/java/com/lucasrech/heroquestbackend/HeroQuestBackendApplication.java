package com.lucasrech.heroquestbackend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HeroQuestBackendApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach((entry) -> System.setProperty(entry.getKey(), entry.getValue()));
        SpringApplication.run(HeroQuestBackendApplication.class, args);
    }

    @RequestMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World!");
    }

}
