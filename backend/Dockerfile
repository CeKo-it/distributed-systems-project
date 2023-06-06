# BUILD STAGE
FROM gradle:7.6.1-jdk17 AS build
WORKDIR /app
COPY build.gradle.kts settings.gradle.kts ./
COPY src ./src
RUN gradle assemble

# FINAL STAGE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar ./ds-backend-app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "ds-backend-app.jar"]
