# 빌드 단계
FROM gradle:7.6-jdk AS builder

WORKDIR /app

COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test --no-daemon

# 실행 단계
FROM openjdk:17-jdk

WORKDIR /app

COPY --from=builder /app/build/libs/*SNAPSHOT.jar ./app.jar

# 빌드 중 전달된 환경 변수 설정
ARG SECRET_KEY

# Docker에서 바로 환경 변수를 사용하도록 설정 (GitHub Secrets 사용)
ENV SECRET_KEY=${SECRET_KEY}

EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]
