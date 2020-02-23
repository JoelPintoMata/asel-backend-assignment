FROM frolvlad/alpine-java:latest

# Set the working directory to /app
WORKDIR /app

# Make port 80 available to the world outside this container
EXPOSE 80

# Copy binary
COPY target/asel-backend-assignment-1.0-SNAPSHOT.jar .

# Start the application
ENTRYPOINT ["java", "-jar", "asel-backend-assignment-1.0-SNAPSHOT.jar"]