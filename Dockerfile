# Stage 1: Build
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copiar pom.xml y archivos fuente
COPY pom.xml .
COPY src ./src

# Ejecutar mvn package para construir el .jar
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copiar el .jar desde el stage anterior
COPY --from=build /app/target/erp-ventas-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto (ajustar según tu configuración)
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
