# Use an official Maven image with OpenJDK 17 to build the application
FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17

# Set proxy environment variables
ENV HTTP_PROXY=http://krmp-proxy.9rum.cc:3128
ENV HTTPS_PROXY=http://krmp-proxy.9rum.cc:3128

# Set the working directory in the container
WORKDIR /home/maven/project

# Spring 소스 코드를 이미지에 복사
COPY /Java/pom.xml .
COPY /Java/src ./src


# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Debug: Print the contents of settings.xml to verify it was copied correctly
RUN echo "Contents of /root/.m2/settings.xml:" && cat /root/.m2/settings.xml
RUN echo "Find  settings.xml :" && find . -name settings.xml


COPY ./settings.xml /root/.m2/settings.xml



# Configure Maven proxy settings
RUN echo "systemProp.http.proxyHost=krmp-pgit roxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" > ./settings.xml


# Package the application
RUN mvn clean install package -DskipTests -s ./settings.xml -X 

# Run the application (adjust the path of the JAR file if necessary)
CMD ["java", "-jar", "target/jweb-0.0.1-SNAPSHOT.jar"]





