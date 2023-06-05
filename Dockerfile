# Use a base image with Java 17 and Alpine Linux
FROM eclipse-temurin:17-jre-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file to the container
COPY build/libs/distributed-systems-project-0.0.1-SNAPSHOT.jar ./my-spring-boot-app.jar

# Expose the port that the Spring Boot application listens on
EXPOSE 8080

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "my-spring-boot-app.jar"]