# spring-boot-reactive-microservices
> This project is example to illustrate how to -
- create Spring Boot reactive microservice
- Spring Boot reactive microservice service registery using Eureka
- create microservice using zipkin centralized log server and its sleuth connector to collect log of microservice
- document Spring Boot reactive with Swagger2

## Requirements

- Java 8
- Maven 3

## How to run?

### Build all modules:
 `mvn clean package -DskipTests=true`

**Microservices created:**

* account-service:
    * hostname: account-service
    * URL: http://localhost:8181
    
* customer-service   
    * hostname: customer-service
    * URL: http://localhost:8282

## Test microservice REST API

Now open your favorite web-browser to `http://localhost:{microservice_port}/swagger-ui.html` which is automatically
generated from the microservice specific Controller web-flux mapping.