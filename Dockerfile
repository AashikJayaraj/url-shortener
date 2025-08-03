# Use official OpenJDK 17 image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the JAR file into the image (replace with your actual JAR name)
COPY target/urlshortener-0.0.1-SNAPSHOT.jar urlshortener.jar

# Expose the application's port
EXPOSE 8080

# Run the JAR
ENTRYPOINT ["java", "-jar", "urlshortener.jar"]
