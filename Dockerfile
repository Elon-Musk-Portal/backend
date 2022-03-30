FROM gradle:7.4.0-jdk11-alpine AS build
COPY --chown=gradle:gradle . /app
RUN apk --no-cache add curl
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["gradle", "bootRun"]
