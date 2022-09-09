package com.example.demo;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@RequestMapping(value = "/demo2", produces = MediaType.APPLICATION_JSON_VALUE)
public class HellodockerApplication {

  public static void main(String[] args) {
    SpringApplication.run(HellodockerApplication.class, args);
  }

  @GetMapping("/getDetails")
  public ResponseEntity<String> get() {
    log.info("Demo2 "+ LocalDateTime.now());
  //  return new ResponseEntity<>("Surprise ", HttpStatus.GATEWAY_TIMEOUT);
    return ResponseEntity.ok("Demo2 updated " + LocalDateTime.now());
  }

  @GetMapping("/getDetails/{id}")
  public ResponseEntity<String> get(@PathVariable Integer id) {
    if(id % 2 ==0){
      log.info("error  "+ LocalDateTime.now());
      return new ResponseEntity<>("INTERNAL SER ERR ", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    log.info("Demo2 "+ LocalDateTime.now());
    return new ResponseEntity<>("Good ", HttpStatus.OK);
    //return ResponseEntity.ok("Demo2 " + LocalDateTime.now());
  }

}
