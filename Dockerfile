FROM openjdk:8-jdk-alpine

ENV PORT 8080
#ENV ENVIRONMENT_NAME=""

ADD ./target/*.war /opt/app/
ADD mvnw /opt/app
RUN chmod +x /opt/appmvnw

WORKDIR /opt/app/

EXPOSE $PORT

CMD ["sh", "./mvnw spring-boot:run"]
