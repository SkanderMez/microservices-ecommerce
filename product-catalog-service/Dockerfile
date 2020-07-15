FROM openjdk:8-jdk-alpine
MAINTAINER Skander MEZIANE <meziane.skander05@gmail.com>
ARG JAR_FILE 
COPY ${JAR_FILE} product-catalog-service.jar
ENTRYPOINT ["java", "-jar", "/product-catalog-service.jar"]
EXPOSE 6666
