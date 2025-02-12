FROM gradle:7.6-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build --no-daemon

FROM openjdk:17-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*SNAPSHOT.jar ./app.jar

EXPOSE 8761

CMD [ "java","-jar","app.jar" ]