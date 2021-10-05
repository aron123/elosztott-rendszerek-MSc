# Eureka Service Discovery (5. hét)

A projekt 4 Spring alkalmazásmodult tartalmaz:
* `eureka-server`: Az Eureka Service Registry-t futtató alkalmazás. Elindítása után alapértelmezetten a http://localhost:8761/ oldalon elérhető a registry aktuális állapota (regisztrált service-k, erőforrás felhasználás, stb.)
* `storage-service`: Eureka Service, elindítása után regisztrálja magát az Eureka Serveren. A http://localhost:8081/deliver végpontot meghívva minden alkalommal eggyel csökken a hátralévő termékek száma.
* `order-service`: Eureka Service, elindítása után regisztrálja magát az Eureka Serveren. Elindítása után a http://localhost:8080/order végpontot meghívva minden alkalommal eggyel csökken a hátralévő termékek száma. A végpontot kiszolgáló kontroller a háttérben a megfelelően annotált `StorageClient` interfész felhasználásával a `storage-service` megfelelő szolgáltatását hívva hajtja végre a műveletet.
* `gateway-service`: Eureka Service, elindítása után regisztrálja magát az Eureka Serveren, rajta keresztül lehet meghívni a többi servicet is. A http://localhost:8000/order végpont alatt tudjuk elérni az order-servicet.

Az egyes service-k alapértelmezett portjai a megfelelő modulban található `src/main/resources/application.properties` konfigurációs fájl módosításával felülírhatók.

Az egyes modulok mindegyike tartalmaz egy-egy `main` metódust, így klasszikus módon, Maven segítségével fordíthatók, majd java segítségével futtathatók.
