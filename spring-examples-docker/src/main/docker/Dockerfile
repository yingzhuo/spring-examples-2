FROM openjdk:8u212-jdk-alpine3.9

MAINTAINER 应卓 yingzhor@gmail.com

USER root

WORKDIR /

RUN mkdir -p /application/{lib,tmp,etc,log}

COPY --chown=root:root  *.jar                    /application/app.jar

COPY --chown=root:root  docker-entrypoint.sh     /docker-entrypoint.sh

VOLUME /application/tmp /application/log

ENV TZ Asia/Shanghai

EXPOSE 8080

ENTRYPOINT ["sh", "/docker-entrypoint.sh"]
