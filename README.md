Spring Boot Benchmark
===

Description
---

Simple, conventional setup of a Spring Boot API to test performance of regular tasks.

The API provides three resources:

1. `<host:port>/tests/hash`
2. `<host:port>/tests/google`
3. `<host:port>/tests/journal`
4. `<host:port>/tests/geography`

Usage
---
1. Clone project
2. From root of project clone, on a command line, execute: `docker-compose up`
3. From root of project clone, on a command line, execute: `./gradlew bootRun`

API will be accessible at: `localhost:8080/tests/<resource>`