
# 🚀 Tenpo Code Challenge

## 🧩 Descripción del Desafío

El objetivo de este proyecto es construir una API REST utilizando **Spring Boot** (Java 21) que exponga un servicio para calcular una suma con incremento porcentual, obteniendo dicho porcentaje desde un servicio externo simulado.

La lógica básica consiste en recibir dos números, sumarlos y aplicarles un incremento porcentual. Por ejemplo:  
**Entrada:** `5` y `5`, **porcentaje recibido:** `10` → **Resultado:** `(5 + 5) + 10% = 11.0`

---

## ⚙️ Funcionalidades implementadas

- ✅ Endpoint REST que suma dos números y aplica un porcentaje dinámico.
- ✅ El porcentaje es obtenido desde un servicio externo simulado (mock).
- ✅ Implementación de **caché temporal de 30 minutos** para el porcentaje.
- ✅ Soporte de reintentos ante fallos del servicio externo (hasta 3 intentos).
- ✅ Fallback: si el servicio externo falla y no hay valor cacheado, se retorna un error apropiado.
- ✅ Registro de todas las llamadas a los endpoints, incluyendo respuesta y estado (exitoso o fallido), con paginación.
- ✅ Historial persistido en una base de datos **PostgreSQL**.
- ✅ El registro de historial no impacta el rendimiento del servicio principal (asíncrono).
- ✅ Límite de 3 solicitudes por minuto por usuario (rate limiting).
- ✅ Manejo adecuado de errores HTTP (códigos y descripciones para 4XX y 5XX).
- ✅ Cobertura de pruebas unitarias.
- ✅ Contenedores de **API y base de datos** desplegables vía **Docker Compose**.
- ✅ Swagger UI y Postman Collection incluidos para facilitar la exploración de la API.

---

## 🧱 Stack Tecnológico

- **Java 21**
- **Spring Boot 3**
- **Gradle 8.13**
- **WebFlux**
- **PostgreSQL**
- **Caffeine (cache)**
- **Docker & Docker Compose**

---

## 🧪 Testing

Para correr los tests:

```bash
./gradlew test
```

---

## 🐳 Ejecución del proyecto con Docker

1. Cloná el repositorio.
2. Ejecutá:

```bash
docker-compose up --build
```

3. Accedé a la documentación Swagger:

👉 http://localhost:8080/swagger-ui.html

---

## 🧾 Mock de porcentaje

Se utilizó el siguiente mock externo para simular la obtención del porcentaje:

📍 https://a6530118-93ae-4994-9512-73735a03c189.mock.pstmn.io/percentage

---

## 📬 Postman Collection

Dentro del repositorio encontrarás una carpeta `collection/` con una colección lista para importar y probar los endpoints fácilmente desde **Postman**.

---

## 📦 DockerHub

La imagen del servicio se encuentra disponible públicamente:

```bash
docker pull alejocarballo/tenpo:latest
```

---

## 🏗️ Arquitectura

Este proyecto sigue una estructura basada en **Arquitectura Hexagonal (Ports & Adapters)** con enfoque en **Domain-Driven Design (DDD)**.  
Esto facilita la escalabilidad, testeo e integración con otros sistemas distribuidos.
