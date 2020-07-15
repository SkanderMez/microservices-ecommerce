FROM openjdk:8-jdk-alpine
MAINTAINER Skander MEZIANE <meziane.skander05@gmail.com>
ARG JAR_FILE 
COPY ${JAR_FILE} api-gateway.jar
ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]
EXPOSE 3333
