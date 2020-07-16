FROM openjdk:8-jdk-alpine
MAINTAINER Skander MEZIANE <meziane.skander05@gmail.com> 
COPY target/api-gateway api-gateway.jar
ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]
EXPOSE 3333
