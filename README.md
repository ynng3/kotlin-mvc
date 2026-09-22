# Kotlin Spring Boot MVC Example (Java Project Clone)

This repository is a simple Spring Boot example created by porting the Java example [spring-boot-mvc](https://github.com/ynng3/spring-boot-mvc) to Kotlin. It is intended for learning purposes and includes the following features:

1. Create
2. Update
3. Delete
4. Read
5. Login

Passwords are stored using `BCrypt` hashing.

## Tech Stack

- Kotlin 1.9
- Java 17
- Spring Boot 3.3.2
- Spring Web
- Spring Data JPA
- Spring Security Crypto (BCrypt)
- H2 (default, for development)

To use PostgreSQL in production, update `src/main/resources/application.yml`.

## Quick Start

Run with the Gradle Wrapper on Windows:

```powershell
./gradlew.bat bootRun
```

Or on Unix-based systems:

```bash
./gradlew bootRun
```

The default setup uses an H2 in-memory database in `src/main/resources/application.yml`, and the application runs on port `8080`.

## Database (When Switching to PostgreSQL)

Create a PostgreSQL database first:

```sql
CREATE DATABASE spring_mvc_db;
```

Then update the `spring.datasource` settings in `application.yml` as shown below:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/spring_mvc_db
    username: postgres
    password: postgres
```

## API

Base URL: `http://localhost:8080`

1) Create User

`POST /api/users`

```json
{
  "username": "tester01",
  "password": "password123",
  "email": "tester01@example.com"
}
```

2) Update User

`PUT /api/users/{id}`

```json
{
  "username": "tester01_new",
  "email": "tester01_new@example.com"
}
```

3) Delete User

`DELETE /api/users/{id}`

4) Get User

`GET /api/users/{id}`

5) Login

`POST /api/auth/login`

```json
{
  "username": "tester01",
  "password": "password123"
}
```

## Notes

This project is for learning and experimentation. It ports the original Java example's structure and functionality to Kotlin.
