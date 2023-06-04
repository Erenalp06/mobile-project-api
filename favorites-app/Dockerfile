FROM openjdk:19
WORKDIR /app
EXPOSE 6767
ADD target/favorites-app.jar favorites-app.jar
ENTRYPOINT ["java", "-jar", "/app/favorites-app.jar"]
