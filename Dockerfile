FROM openjdk:17-jdk-alpine
COPY target/kaiburrassessment-0.0.1-SNAPSHOT.jar kaiburrassessment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/kaiburrassessment-0.0.1-SNAPSHOT.jar"]