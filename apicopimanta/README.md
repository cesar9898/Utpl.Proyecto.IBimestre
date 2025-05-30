# Sistema de Gestión de Órdenes de Producción - API Copimanta

Este proyecto es una API REST desarrollada con Spring Boot para la gestión de órdenes de producción en una imprenta. Permite crear, consultar, actualizar y listar órdenes de producción, así como visualizar los estados de las mismas.

## Características principales

- **Gestión de órdenes:** Crear nuevas órdenes de producción con información de cliente, trabajos y estado.
- **Actualización de órdenes:** Modificar datos de órdenes existentes.
- **Consulta de estados:** Listar los posibles estados de una orden de producción.
- **Endpoints REST:** Acceso a través de rutas `/api/ordenes-produccion`.

## Estructura del proyecto

- `src/main/java/com/ordenesproduccion/apicopimanta/controladores`: Controladores REST de la API.
- `src/main/java/com/ordenesproduccion/apicopimanta/dtos`: Objetos de transferencia de datos (DTOs).
- `src/main/resources/application.properties`: Configuración de la aplicación.
- `src/test/java/com/ordenesproduccion/apicopimanta`: Pruebas unitarias.

## Ejemplo de uso de la API

- **Obtener lista de órdenes:**  
  `GET /api/ordenes-produccion/ordenes`

- **Crear una nueva orden:**  
  `POST /api/ordenes-produccion/ordenes`

- **Actualizar una orden:**  
  `PUT /api/ordenes-produccion/ordenes/{id}`

- **Listar estados de órdenes:**  
  `GET /api/ordenes-produccion`

## Requisitos

- Java 21
- Maven 3.9.x

## Ejecución

Para ejecutar la aplicación localmente:

```sh
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080/api/ordenes-produccion`.

## Licencia

Este proyecto está bajo la licencia Apache 2.0.