FROM maven:3-eclipse-temurin-21

WORKDIR /app

COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .
COPY src src
COPY .mvn .mvn

RUN mvn package -Dmaven.test.skip=true

ENV PORT=3000

EXPOSE ${PORT}

ENTRYPOINT SERVER_PORT=${PORT} java -jar target/ws13-0.0.1-SNAPSHOT.jar
