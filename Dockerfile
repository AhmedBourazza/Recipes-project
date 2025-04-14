FROM openjdk:17-jdk-slim
COPY target/recipesApp.jar recipesApp.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","recipesApp.jar"]