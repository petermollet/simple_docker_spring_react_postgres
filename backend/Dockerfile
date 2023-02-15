FROM maven:3.8.1-openjdk-17-slim AS maven
WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/*.jar /opt/app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
