# Usa una imagen de Java 17
FROM openjdk:17-jdk-slim

# Crea un directorio dentro del contenedor para la app
WORKDIR /app

# Copia el .jar compilado
COPY target/erp-ventas-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto que usa Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
