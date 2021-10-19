# Elasticsearch (7. hét)
A projekt egy Elasticsearch-öt használó Spring Boot alapú chat alkalmazást tartalmaz.

## Indítás
1. Elasticsearch docker image letöltése : `docker pull docker.elastic.co/elasticsearch/elasticsearch:7.15.1`
2. Elasticsearch elindítása: `docker run -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.15.1`
3. Projekt fordítása: `mvn clean package`
4. Alkalmazás indítása: `java -jar target/elastic-0.0.1-SNAPSHOT.jar`

## Használat
Az alkalmazás elindítása után a szerver alapértelmezetten a localhost 8080-as portján fogad kéréseket.

A /chat végpontra POST kérés küldhető, az alábbi formátumú törzzsel:
```json
{
"id": "string",
"message": "string",
"sender": "string",
"roomId": "string",
"roomName": "string"
}
```

A /chat végpontra GET kérést küldve lekérdezhetők egy adott küldőtől származó üzenetek. A küldő neve a `query` nevű paraméterben adható át.

A /chat/find végpontra GET kérést küldve a küldők, az üzenetek és a szoba neve alapján tudunk keresni. A keresőszót szintén a `query` nevű paraméterben kell átadni.

Az API Swaggerrel generált dokumentációja a http://localhost:8080/swagger-ui.html útvonalon érhető el. Ezen az oldalon lehetőség van kérések küldésére is.