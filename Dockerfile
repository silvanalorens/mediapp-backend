#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim
#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="silvanalorens"
COPY target/mediapp-backend-0.0.1-SNAPSHOT.jar mediapp-backend-0.0.1-SNAPSHOT.jar
# execute the application
ENTRYPOINT ["java", "-jar", "mediapp-backend-0.0.1-SNAPSHOT.jar"]