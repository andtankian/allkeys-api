FROM openjdk:8-alpine
WORKDIR /opt/api/
COPY target .
RUN mkdir /opt/api/statics && mkdir /opt/statics && mkdir /home/statics
ENTRYPOINT ["java", "-jar", "allkeys-api-1.4.3.jar"]
EXPOSE 2007
