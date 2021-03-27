FROM openjdk:15-jdk-slim
ARG JAR_FILE=./overlord-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar