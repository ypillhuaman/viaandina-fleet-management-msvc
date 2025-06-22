FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
ADD ./target/viaandina-fleet-management-msvc-0.0.1-SNAPSHOT.jar viaandina-fleet-management-msvc.jar

ENTRYPOINT [ "java", "-jar", "viaandina-fleet-management-msvc.jar" ]