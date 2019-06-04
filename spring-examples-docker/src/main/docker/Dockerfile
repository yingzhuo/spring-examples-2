FROM openjdk:8u212-jdk-alpine3.9

MAINTAINER 应卓 yingzhor@gmail.com

USER root

ARG JAR_FILE

WORKDIR /

RUN  mkdir -p \
    /application/lib \
    /application/tmp \
    /application/etc \
    /application/log

COPY --chown=root:root  $JAR_FILE                /application/app.jar

COPY --chown=root:root  docker-entrypoint.sh     /docker-entrypoint.sh

ENV TZ Asia/Shanghai

EXPOSE 8080

ENTRYPOINT ["sh", "/docker-entrypoint.sh"]

