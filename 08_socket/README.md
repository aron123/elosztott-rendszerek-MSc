# WebSocket (8. hét)
A projekt egy WebSocket-en kommunikáló Spring Boot alapú szervert, és HTML+JavaScript klienst tartalmaz, melyek egy klasszikus chat alkalmazás komponensei.

## Indítás
Spring Boot alkalmazás fordítása és futtatása

## Használat
A http://localhost:8080/ URL-en elérhető felületen a Connect gombra kattintva tud a kliens csatlakozni a szerverhez, ekkor létrejön kettejük között a WebSocket kapcsolat. Egymással STOMP protokollon keresztül kommunikálnak.

A "Message" beviteli mezőt kitöltve, majd a "Send" gombot megnyomva a kliens továbbítja a beírt üzenetet a szervernek. A szerver ezután minden csatlakozott kliensnek átadja az üzenetet, amit a kliensek megjelenítenek a "Messages" táblázatban.