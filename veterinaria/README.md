
# Microservicio de Facturación Veterinaria 🐾

Este proyecto es un microservicio desarrollado en Java con Spring Boot, Maven y Oracle SQL para gestionar la facturación de servicios veterinarios.

## Tecnologías
- Java 17
- Spring Boot
- Maven
- Oracle SQL
- JUnit 5
- HATEOAS
- Postman

## Estructura
- CRUD de clientes, mascotas, servicios y facturas
- Generación de facturas y detalle
- Validaciones de datos
- Documentación HATEOAS
- Pruebas unitarias
- Scripts SQL

## Ejecución local

1. **Configura Oracle DB**:
   - Ejecuta los scripts en `/sql/create_tables.sql` y `/sql/insert_data.sql`.

2. **Configura `application.properties`**:

```
spring.datasource.url=jdbc:oracle:thin:@//HOST:PORT/SERVICIO
spring.datasource.username=USUARIO
spring.datasource.password=CONTRASEÑA
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```

3. **Compila y ejecuta**:
```bash
./mvnw clean install
./mvnw spring-boot:run
```

4. **Prueba con Postman**:
   - Endpoints disponibles en `FacturaController`, `ServicioController`, etc.
   - Respuestas incluyen enlaces HATEOAS.

## Pruebas

```bash
./mvnw test
```

Incluye pruebas unitarias básicas en `src/test`.

## Despliegue en la nube

Puedes desplegar en servicios como Render, Railway o una máquina de Oracle Cloud:

- Sube el `.zip` con el proyecto completo
- Configura variables de entorno para Oracle DB
- Usa Maven para construir y correr

---

_Desarrollado para la Evaluación Final Transversal (Semana 9) - Duoc UC_
