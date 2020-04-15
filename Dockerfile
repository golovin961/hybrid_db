FROM openjdk:8-jdk-alpine

ENV PORT 5000
#ENV ENVIRONMENT_NAME=""

COPY ./target/*.jar /opt/app/

WORKDIR /opt/app/

EXPOSE $PORT

CMD ["sh", "-c", "find -type f -name '*.war' | xargs java -jar -Dserver.port=${PORT}"]
