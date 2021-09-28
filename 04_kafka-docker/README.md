# Docker, Apache Kafka használata, Spring integráció (4. hét)
A projekt egy Spring MVC webalkalmazás, mely tartalmazza a 4. héten megoldott feladatokat.

A `kafka-producer` projekt egy termelő alkalmazás, mely chat-üzeneteket küld be a beállított topic-ba.

A `kafka-consumer` projekt egy fogyasztó alkalmazás, mely kiolvassa a beállított topic-ban szereplő üzeneteket.

## Használat
1. Kafka docker képfájl letöltése: `git clone https://github.com/wurstmeister/kafka-docker.git`
2. Konfiguráció: `docker-compose-single-broker.yml`-ben `KAFKA_ADVERTISED_HOST_NAME` átírása `localhost`-ra.
3. Kafka futtatása dockerben: `docker-compose -f docker-compose-single-broker.yml up`
4. Kafka producer alkalmazás futtatása:
    ```
    cd kafka-producer
    mvn clean package
    java -jar target/kafka-producer-0.0.1-SNAPSHOT.jar
    ```
5. Kafka consumer alkalmazás futtatása:
    ```
    cd kafka-consumer
    mvn clean package
    java -jar target/kafka-consumer-0.0.1-SNAPSHOT.jar
    ```