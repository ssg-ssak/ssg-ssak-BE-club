FROM openjdk:17-alpine
COPY build/libs/pointapp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8001
ENTRYPOINT ["java","-jar", "-Duser.timezone=Asia/Seoul", "-Dspring.profiles.active=prod", "/app.jar"]