
FROM eclipse-temurin:21-jdk-focal AS build

WORKDIR /app

# Build aşamasından jar dosyasını kopyala
COPY --from=build /app/target/portfolio-service-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java","-jar","app.jar"]

# Optional: port expose (Spring Boot default: 8080)
EXPOSE 8080
