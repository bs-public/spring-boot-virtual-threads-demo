# Spring boot demo Virtual Threads

## By Spring configuration 
With Spring Boot you can enable virtual thread by setting the following property instead of manual configuration. When enabled, Spring Boot leverage virtual threads by using them for various Spring components such as MVC, JDBC and task executors etc.
```
spring.threads.virtual.enabled=true
```

## By Manual configuration for certain components
Replacing the default Tomcat thread pool with a virtual thread executor. Instead of using a fixed thread pool, Tomcat now creates a new virtual thread for each request.
```
@Bean
public TomcatProtocolHandlerCustomizer<?> protocolHandlerVirtualThreadExecutorCustomizer() {
    return handler -> handler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
}
```

## Run the application
```
$ ./mvnw spring-boot:run
``` 

## Invoke the service
```
$ curl localhost:8080
Hello from VirtualThread[#39]/runnable@ForkJoinPool-1-worker-1
```
