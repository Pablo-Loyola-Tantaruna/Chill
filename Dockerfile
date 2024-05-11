# Use an official Maven image as a parent image
FROM maven:3.6.3-openjdk-17 as build

# Set the working directory in the image to /app
WORKDIR /app

# Start with a base image containing Java runtime
FROM openjdk:17-jdk

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Set the application's jar file
ADD ./target/service-product-management-1.0.0-jar-with-dependencies.jar service-product-management-1.0.0.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/service-product-management-1.0.0.jar"]