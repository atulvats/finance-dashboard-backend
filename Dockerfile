# Use Java 17
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build jar
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

# Run jar
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]