FROM openjdk:8-jdk-alpine
MAINTAINER Skander MEZIANE <meziane.skander05@gmail.com>
ARG JAR_FILE 
COPY ${JAR_FILE} product-recommendation-service.jar
ENTRYPOINT ["java", "-jar", "/product-recommendation-service.jar"]
EXPOSE 7777
