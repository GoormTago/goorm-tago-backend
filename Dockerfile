# Use an official Maven image with OpenJDK 1.8 to build the application
FROM krmp-d2hub-idock.9rum.cc/goorm/openjdk:17

# Set proxy environment variables
ENV HTTP_PROXY=http://krmp-proxy.9rum.cc:3128
ENV HTTPS_PROXY=http://krmp-proxy.9rum.cc:3128



# Set the working directory in the container
WORKDIR /home/maven/project

# Spring 소스 코드를 이미지에 복사
COPY . .


# Maven  version 확인
CMD ["java", "--version"]
CMD ["maven", "--version"]


# Install Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Maven  version 확인
CMD ["java", "--version"]
CMD ["maven", "--version"]

# Configure Maven proxy settings
RUN echo "systemProp.http.proxyHost=krmp-pgit roxy.9rum.cc\nsystemProp.http.proxyPort=3128\nsystemProp.https.proxyHost=krmp-proxy.9rum.cc\nsystemProp.https.proxyPort=3128" > /root/.m2/settings.xml

# Copy the project files to the container
COPY /Java/pom.xml .
COPY /Java/src ./src

# Package the application
RUN mvn clean install package -DskipTests -X


# 빌드 결과 jar 파일을 실행
CMD ["java", "-jar", "/home/maven/project/target/home/maven/project"]






# Expose the port the application will run on
# EXPOSE 8080

# Run the application
#ENTRYPOINT ["java", "-jar", "app.jar"]