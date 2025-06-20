# ### STAGE 1: Build ###
FROM maven:3.9.8-eclipse-temurin-21-alpine AS java

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package -DskipTests

### STAGE 2: Run ###
FROM eclipse-temurin:21-alpine

ARG JAR_FILE=/app/target/Vertical-Logistics-API-0.0.1-SNAPSHOT.jar

COPY --from=java ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080