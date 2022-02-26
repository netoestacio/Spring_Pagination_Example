from openjdk:12-alpine
MAINTAINER github/netoestacio
COPY ./target/core-0.0.1-SNAPSHOT.jar /app/core-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "core-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080