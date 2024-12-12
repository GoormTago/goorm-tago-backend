# Use an official Maven image with OpenJDK 1.8 to build the application
#FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17


# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*
