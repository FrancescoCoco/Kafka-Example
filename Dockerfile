FROM openjdk:17
COPY target/kafka-producer-0.0.1-SNAPSHOT.jar kafka-example.jar
ENTRYPOINT ["java", "-jar", "kafka-example.jar"]