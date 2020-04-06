#### Stage 1: Build the application
FROM openjdk:8-jdk-alpine
FROM openjdk:8-jdk-alpine as build

# Set the current working directory inside the image
WORKDIR /app

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Build all the dependencies in preparation to go offline. 
# This is a separate step so the dependencies will be cached unless 
# the pom.xml file has changed.
RUN ./mvnw dependency:go-offline -B

# Copy the project source
COPY src src

# Package the application
RUN ./mvnw package -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#### Stage 2: A minimal docker image with command to run the app 
FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/app/target/dependency

RUN pwd
# Copy project dependencies from the build stage
COPY kafka-logger/ ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY kafka-logger/ ${DEPENDENCY}/META-INF /app/META-INF
COPY kafka-logger/ ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.bilginyuksel.kafkalogger.KafkaLoggerApplication"]

