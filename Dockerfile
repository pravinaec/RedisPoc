# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/spring-rest-hello-world-1.0.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-rest-hello-world-1.0.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]