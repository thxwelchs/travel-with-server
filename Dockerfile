FROM java:8

WORKDIR /root

COPY build/libs/api-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-Djava.security.deg=file:/dev/ ./urandom", "-Dspring.profiles.active=prod", "-jar", "api-0.0.1-SNAPSHOT.jar"]
