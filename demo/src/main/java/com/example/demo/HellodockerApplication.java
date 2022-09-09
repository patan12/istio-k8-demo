package com.example.demo;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@EnableFeignClients
@RequestMapping(value = "/demo1", produces = MediaType.APPLICATION_JSON_VALUE)
public class HellodockerApplication {

  @Autowired
  private Demo2Client demo2Client;

  public static void main(String[] args) {
    SpringApplication.run(HellodockerApplication.class, args);
  }

  @GetMapping("/getDetails")
  public ResponseEntity<String> get() {
    log.info("Demo1-updated req" + LocalDateTime.now());
    return ResponseEntity.ok(
        "Demo1 " + LocalDateTime.now() + " " + demo2Client.getDetails().getBody());
  }

}
