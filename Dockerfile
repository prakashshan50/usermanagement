FROM maven:3.6.2-jdk-8-slim AS build
ADD . usermanagement/
ADD settings.xml /root/.m2/settings.xml
RUN mvn -X -f usermanagement/pom.xml clean package

ARG VERSION
FROM java:8
ENV APP /usermanagement
ENV JAVA_OPTS=""
RUN mkdir -p $APP && mkdir $APP/logs
VOLUME $APP/logs
WORKDIR $APP
COPY --from=build $APP/target/usermanagement-${VERSION}-SNAPSHOT.jar $APP/usermanagement-${VERSION}-SNAPSHOT.jar
ENTRYPOINT exec java $JAVA_OPTS -jar usermanagement-${VERSION}-SNAPSHOT.jar $0 $@
