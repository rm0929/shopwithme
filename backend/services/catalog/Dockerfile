FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copy pom and wrapper first for better layer caching
COPY pom.xml mvnw* ./
COPY .mvn .mvn

# Copy source and build
COPY src src

RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre

RUN apt-get update && apt-get install -y --no-install-recommends curl \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY --from=build /app/target/catalog-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]
