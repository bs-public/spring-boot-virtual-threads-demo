package com.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import java.util.concurrent.Executors;

@Configuration
public class Config {

  @Bean
  @ConditionalOnProperty(name = "app.tomcat.threads.virtual.enabled", havingValue = "true")
  public TomcatProtocolHandlerCustomizer<?> tomcatProtocolHandlerCustomizer() {
    return handler -> handler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
  }

  @Bean(name = "virtualThreadExecutor")
  @ConditionalOnProperty(name = "app.async.threads.virtual.enabled", havingValue = "true")
  public AsyncTaskExecutor virtualThreadExecutor() {
    return new ConcurrentTaskExecutor(Executors.newVirtualThreadPerTaskExecutor());
  }
}
