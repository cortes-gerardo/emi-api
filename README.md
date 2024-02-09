# EMI-API
_Equated Monthly Installment calculator Backend_

## Description
API that takes a request with loan value, interest rate and loan term and calculates the equated monthly installment

This application is designed to run with EMI-UI, you can run it locally by following the steps in [Run](#run)

Once the application is running you can check the live documentation here http://127.0.0.1:8080/swagger-ui/index.html

---

# Local Development

## Technology Stack
- [Java 17](https://openjdk.org/projects/jdk/17/)
- [Spring Boot v3.2.2](https://spring.io/projects/spring-boot)
- [Maven 3.9.5](https://maven.apache.org/download.cgi?Preferred=ftp://ftp.osuosl.org/pub/apache/)

## Build
```shell
$ ./mvnw clean compile
```

## Test
To ensure the local environment is all set you can run the tests.
```shell
$ ./mvnw clean verify
```

## Run
One of the benefits of Sprint Boot is that it comes with an embedded web server. Using the Maven build provided by the _Spring Boot Initialzr_, you'll get a `.jar` file inside the `/target` directory. You can use the `.jar` file to locally run the entire Spring application.
```shell
# generates emi-api-0.0.1-SNAPSHOT.jar
$ ./mvnw clean install

# runs the application using the embedded web server.
$ java -jar target/emi-api-0.0.1-SNAPSHOT.jar
```

---

# Authors
- [Gerardo Cortes](mailto:mail@gerardocortes.com?subject=You%20are%20hired)
