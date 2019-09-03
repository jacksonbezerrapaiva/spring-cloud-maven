FROM maven:3.6.1-jdk-8-slim AS build

RUN mkdir /app
COPY . /app
WORKDIR /app
RUN mvn install -DskipTests=true


FROM openjdk:8-jre-slim

EXPOSE 8090
RUN mkdir /app
COPY --from=build /app/target/dashboard-0.0.1-SNAPSHOT.jar /app/dashboard-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/dashboard-0.0.1-SNAPSHOT.jar"]