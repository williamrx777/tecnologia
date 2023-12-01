FROM openjdk:17
WORKDIR /tecnologia

CMD ["./gradlew", "clean", "bootJar"]

COPY build/libs/*.jar tecnologia.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","/tecnologia.jar"]