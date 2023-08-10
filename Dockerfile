FROM eclipse-temurin:17-jdk-focal

COPY target/ws-productos-activos-0.0.1-SNAPSHOT.jar ws-productos-activos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/ws-productos-activos-0.0.1-SNAPSHOT.jar"]