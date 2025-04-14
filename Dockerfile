# -------- STAGE 1: Compilación con Gradle --------
FROM eclipse-temurin:21-jdk AS builder

# Crear y establecer directorio de trabajo
WORKDIR /app

# Copiar solo archivos necesarios para aprovechar el cache
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Dar permisos al wrapper y compilar
RUN chmod +x ./gradlew && ./gradlew clean build -x test

# -------- STAGE 2: Imagen final ligera --------
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar solo el .jar desde el builder
COPY --from=builder /app/build/libs/*.jar app.jar

# Exponer puerto
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]



   # Mejora	Qué hace / Por qué
   # COPY gradlew, gradle/, etc.	Usa el caché de Docker para no recompilar todo si solo cambia el código fuente
   # -x test	Omite los tests al construir (opcional)
   # *.jar	No acopla al nombre exacto, permite flexibilidad si el JAR cambia de nombre
   # Dos etapas (builder, final)	La imagen final no incluye Gradle, es más liviana y segura