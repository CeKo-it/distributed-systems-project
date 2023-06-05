# BUILD STAGE
FROM gradle:jdk17-jammy AS build

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src

RUN ./gradlew clean build --no-daemon

# Use a base image with Java 17 and Alpine Linux
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY build/libs/*.jar ./ds-backend-app.jar

# Expose the port that the Spring Boot application listens on
EXPOSE 8080
EXPOSE 27017

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "ds-backend-app.jar"]