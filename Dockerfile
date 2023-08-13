FROM eclipse-temurin:17-jdk-focal

EXPOSE 8081
COPY target/ws-productos-activos-0.0.1-SNAPSHOT.jar ws-productos-activos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/ws-productos-activos-0.0.1-SNAPSHOT.jar"]