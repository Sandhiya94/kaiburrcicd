FROM openjdk:17-jdk-alpine
COPY target/kaiburrassessment-0.0.1-SNAPSHOT.jar kaiburrassessment-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/kaiburrassessment-0.0.1-SNAPSHOT.jar"]