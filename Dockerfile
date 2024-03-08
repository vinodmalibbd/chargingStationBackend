# Use a base image with Java 21 installed
FROM adoptopenjdk:21-jdk-hotspot

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Spring Boot JAR file into the container
COPY target/chargingStationBackend.jar /app/app.jar

# Expose the port your Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "app.jar"]