/*
 * Copyright (c) 2018 JCPenney Co. All rights reserved.
 */

package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${demo2.name}", url = "${demo2.url}", path = "${demo2.path}")
public interface Demo2Client {

  @RequestMapping(method = RequestMethod.GET, value = "/getDetails")
  ResponseEntity<String> getDetails();

}
