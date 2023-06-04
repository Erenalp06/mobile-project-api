FROM openjdk:19
WORKDIR /app
EXPOSE 8088
ADD target/news-app-v1.2.jar news-app-v1.2.jar
ENTRYPOINT ["java", "-jar", "/app/news-app-v1.2.jar"]
