# 빌드 단계
FROM gradle:7.6-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build --no-daemon

# 실행 단계
FROM openjdk:17-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*SNAPSHOT.jar ./app.jar

# 빌드 중 전달된 환경 변수 설정
ARG SECRET_KEY

# 런타임에서 환경 변수 설정
ENV SECRET_KEY=${SECRET_KEY}

EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]