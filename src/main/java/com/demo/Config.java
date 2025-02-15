package com.demo;

import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.Executors;

@Configuration
public class Config {

  @Bean
  public TomcatProtocolHandlerCustomizer<?> tomcatProtocolHandlerCustomizer() {
    return handler -> handler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
  }
}
