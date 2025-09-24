FROM maven:3.9.9-eclipse-temurin-23 AS build

WORKDIR /poster

COPY . .

RUN mvn clean install -DskipTests

FROM eclipse-temurin:23-jre-alpine

WORKDIR /cafe

COPY --from=build /poster/target/*.jar poster.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "poster.jar"]