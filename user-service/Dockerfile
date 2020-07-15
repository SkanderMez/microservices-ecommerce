FROM openjdk:8-jdk-alpine
MAINTAINER Skander MEZIANE <meziane.skander05@gmail.com>
ARG JAR_FILE 
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]
EXPOSE 2222
