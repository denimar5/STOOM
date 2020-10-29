
FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/STOOM-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY ${JAR_FILE} app_v1.jar

ENTRYPOINT ["java","-jar","app_v1.jar"]