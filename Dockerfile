FROM openjdk:8-jdk-alpine

ENV PORT 8080
#ENV ENVIRONMENT_NAME=""

ADD ./target/*.war /opt/app/

WORKDIR /opt/app/

EXPOSE $PORT

CMD ["sh", "./mvnw spring-boot:run"]
