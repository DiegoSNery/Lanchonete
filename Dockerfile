# Use a imagem oficial do OpenJDK com o Alpine Linux
FROM openjdk:11

WORKDIR /app

COPY build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
