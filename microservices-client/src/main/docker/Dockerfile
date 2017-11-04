FROM java:8
VOLUME c:/tmp
ADD microservices-client-1.0.0.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9999
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
MAINTAINER lmsys
