# Redis (8. hét)
A projekt egy Redis-t használó Spring Boot alapú, személyek tárolására szolgáló alkalmazást tartalmaz.

## Indítás
1. Redis szerver futtatása Dockerben: `docker run -p 16379:6379 -d redis:6.0 redis-server --requirepass "mypass"`
2. Spring Boot alkalmazás fordítása és futtatása

## Használat
Az alkalmazás 2 végpontot biztosít, alapértelmezetten a localhost 8080-as portján:

* Személyek lekérdezése: `GET http://localhost:8080/person/:id`
* Személyek lekérdezése:
  ```  
  POST http://localhost:8080/person
  Content-Type: application/json

  { "id": "string", "firstname": "string", "lastname": "string" }
  ```