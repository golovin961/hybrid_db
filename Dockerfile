FROM tomcat:latest

ARG WAR_FILE=target/*.war
ADD ${WAR_FILE} /usr/local/tomcat/webapps/

#ENV PORT 8080
#EXPOSE $PORT

CMD ["catalina.sh", "run"]

#ENV ENVIRONMENT_NAME=""

#ADD ./target/*.war /opt/app/
#WORKDIR /opt/app/
