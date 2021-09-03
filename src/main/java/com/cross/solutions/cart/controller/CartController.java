package com.cross.solutions.cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;

/**
 * @author huynhlehoaibac
 * @since 0.0.1-SNAPSHOT
 */
@RequestMapping("/cart")
@RestController
public class CartController {

  @Autowired @Lazy private EurekaClient eurekaClient;

  @GetMapping("")
  public String index() {
    return String.format(
        "Hello from '%s'!", eurekaClient.getApplicationInfoManager().getInfo().getInstanceId());
  }
}
