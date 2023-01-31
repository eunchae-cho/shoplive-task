FROM openjdk:8-jdk-alpine
RUN mkdir -p /app
WORKDIR /app
RUN mkdir -p /ffmpeg/bin
COPY ./src/main/resources/ffmpeg/bin/ffmpeg ./ffmpeg/bin/ffmpeg
COPY ./src/main/resources/ffmpeg/bin/ffprobe ./ffmpeg/bin/ffprobe
#ARG JAR_FILE=./build/libs/task-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=./task-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENV USE_PROFILE dev
ENTRYPOINT ["java", "-Dspring.profiles.active=${USE_PROFILE}", "-jar", "/app/app.jar"]
EXPOSE 8080