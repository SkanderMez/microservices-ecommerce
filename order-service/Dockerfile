FROM openjdk:8-jdk-alpine
MAINTAINER Skander MEZIANE <meziane.skander05@gmail.com>
ARG JAR_FILE 
COPY ${JAR_FILE} order-service.jar
ENTRYPOINT ["java", "-jar", "/order-service.jar"]
EXPOSE 5555
