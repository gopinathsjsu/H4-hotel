#
# Build stage
#
FROM maven:3.6.3-openjdk-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install
ENTRYPOINT ["java","-jar","/home/app/target/hotels-0.0.1-SNAPSHOT.jar"]