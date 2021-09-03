package com.cross.solutions.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author huynhlehoaibac
 * @since 0.0.1-SNAPSHOT
 */
@EnableEurekaClient
@SpringBootApplication
public class CartApplication {

  public static void main(String[] args) {
    SpringApplication.run(CartApplication.class, args);
  }
}
