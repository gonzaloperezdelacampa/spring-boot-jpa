FROM openjdk-11-rhel7:1.11
ARG JAR_FILE=target/docker/estudio.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT java $JAVA_OPTS -jar app.jar
