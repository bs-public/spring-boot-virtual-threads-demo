package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class HelloService {
  private final Logger log = LoggerFactory.getLogger(HelloService.class);

  public String hello() {
    String message = "Hello from %s".formatted(Thread.currentThread());
    log.info(message);
    return message;
  }

  @Async
  public CompletableFuture<String> helloAsync() {
    String message = "Hello from %s".formatted(Thread.currentThread());
    log.info(message);
    return CompletableFuture.completedFuture(message);
  }
}
