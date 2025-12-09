# simple dockerfile for running the built jar
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/sghss-backend-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
