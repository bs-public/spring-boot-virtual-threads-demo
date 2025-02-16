package com.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.Executors;

@Configuration
public class Config {

  @Bean
  @ConditionalOnProperty(
      name = "spring.threads.virtual.enabled",
      havingValue = "false",
      matchIfMissing = true)
  public TomcatProtocolHandlerCustomizer<?> tomcatProtocolHandlerCustomizer() {
    return handler -> handler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
  }
}
