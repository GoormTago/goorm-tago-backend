# Use an official Maven image with OpenJDK 1.8 to build the application
FROM openjdk:8-jdk 

# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Set proxy environment variables
ENV HTTP_PROXY=http://krmp-proxy.9rum.cc:3128
ENV HTTPS_PROXY=http://krmp-proxy.9rum.cc:3128

# Configure Maven proxy settings
RUN echo "systemProp.http.proxyHost=krmp-proxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" > /root/.m2/settings.xml

# Copy the project files to the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use OpenJDK 1.8 to run the application
FROM openjdk:8-jdk

# Set the working directory in the container
WORKDIR /app

# Set proxy environment variables
ENV HTTP_PROXY=http://krmp-proxy.9rum.cc:3128
ENV HTTPS_PROXY=http://krmp-proxy.9rum.cc:3128

# Copy the packaged application from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]