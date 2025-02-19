# Use an official OpenJDK runtime as the base image
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the built .jar file into the container
COPY target/codeGenerator-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring application runs on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]