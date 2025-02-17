package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class HelloController {

  private final HelloService helloService;

  public HelloController(HelloService helloService) {
    this.helloService = helloService;
  }

  @GetMapping(path = "/hello")
  public String hello() {
    return this.helloService.hello();
  }

  @GetMapping(path = "/hello-async")
  public CompletableFuture<String> helloAsync() {
    return this.helloService.helloAsync();
  }
}
