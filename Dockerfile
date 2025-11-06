FROM eclipse-temurin:21-jdk-focal

WORKDIR /app

# Jar dosyanı yerel makineden kopyala
COPY target/portfolio-service-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080
