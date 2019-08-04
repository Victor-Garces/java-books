# BOOK API - Spring Boot, MySQL, JPA Rest API Tutorial

Library API - Spring Boot, MS-SQL and JPA Rest API

## Requirements

1. Java - 1.8.x

2. Maven - 3.3.9

3. MySQL - 14.0    

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/Victor-Garces/java-books.git
```

**2. Create MS-SQL database**

```bash
create database Library
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/db.properties`

+ change `spring.datasource.username` and `spring.datasource.username` as per your with your instance credentials.

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/java-books-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Swagger

The swagger will start running at <http://localhost:8080/swagger-ui.html>

You can test them using postman or in the same swagger service.
