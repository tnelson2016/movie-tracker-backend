# 1. Use the official Maven image to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# 2. Copy your Maven project files
COPY pom.xml .
COPY src ./src

# 3. Package the application
RUN mvn clean package -DskipTests

# 4. Use a lightweight Java runtime for the final image
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# 5. Copy the built JAR file from the build stage
COPY --from=build /app/target/movie-tracker-backend-0.0.1-SNAPSHOT.jar app.jar

# 6. Expose the port your app runs on
EXPOSE 8080

# 7. Run the app
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=${PORT}"]

