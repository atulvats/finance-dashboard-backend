# Use official Java 17 image (correct)
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project
COPY . .

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build project
RUN mvn clean package -DskipTests

# Run app
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
