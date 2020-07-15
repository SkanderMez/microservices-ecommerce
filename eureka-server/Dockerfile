FROM openjdk:8-jdk-alpine
MAINTAINER Skander MEZIANE <meziane.skander05@gmail.com>
ARG JAR_FILE 
COPY ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]
EXPOSE 4444
