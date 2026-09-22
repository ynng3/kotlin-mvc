# Kotlin Spring Boot MVC 예제 (Java 프로젝트 클론)

이 저장소는 `spring-boot-mvc` Java 예제를 Kotlin으로 클론한 간단한 Spring Boot 예제입니다. 학습 목적의 예제로 아래 기능을 포함합니다:

1. Create
2. Update
3. Delete
4. Read
5. Login

비밀번호는 `BCrypt` 해싱으로 저장합니다.

## 기술 스택

- Kotlin 1.9
- Java 17
- Spring Boot 3.3.2
- Spring Web
- Spring Data JPA
- Spring Security Crypto (BCrypt)
- H2 (기본, 개발용)

프로덕션에서 PostgreSQL을 사용하려면 `src/main/resources/application.yml`을 수정해 주세요.

## 빠른 시작

Windows에서 Gradle Wrapper로 실행:

```powershell
./gradlew.bat bootRun
```

또는 Unix 계열:

```bash
./gradlew bootRun
```

기본 설정은 `src/main/resources/application.yml`에 H2 인메모리 DB로 되어 있으며, 포트는 `8080`입니다.

## 데이터베이스 (Postgres로 전환할 경우)

Postgres를 사용하려면 데이터베이스를 생성하세요:

```sql
CREATE DATABASE spring_mvc_db;
```

그리고 `application.yml`의 `spring.datasource` 설정을 아래 예시처럼 변경하세요:

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

## 메모

이 프로젝트는 학습 및 실험용입니다. 원본 Java 예제의 구조와 기능을 Kotlin으로 포팅했습니다.
