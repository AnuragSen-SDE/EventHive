FROM  maven:3.9.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy only pom.xml first to leverage Docker layer caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Now copy source and build
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

# Set timezone to avoid the Asia/Calcutta issue you just hit locally
ENV TZ=Asia/Kolkata
RUN apk add --no-cache tzdata

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

CMD ["java","-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]