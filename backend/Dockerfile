FROM maven:3.6-jdk-8-alpine as build-step

WORKDIR /tmp

COPY pom.xml /tmp
RUN mvn verify clean --fail-never

COPY src /tmp/src
RUN mvn package

##############################################################

FROM openjdk:8-jdk-alpine

COPY --from=build-step /tmp/target/backend.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]