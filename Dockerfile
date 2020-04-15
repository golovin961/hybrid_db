FROM openjdk:8-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} app.war

ENV PORT 8080
EXPOSE $PORT

ENTRYPOINT ["java","-jar","/app.jar"]

ENV PORT 8080
#ENV ENVIRONMENT_NAME=""

#ADD ./target/*.war /opt/app/
#WORKDIR /opt/app/
