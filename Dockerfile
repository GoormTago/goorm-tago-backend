# Use an official Maven image to build the application
FROM maven:3.8.8-jdk-8 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests -X

# Use an OpenJDK image to run the application
FROM openjdk:8-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the packaged application from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
