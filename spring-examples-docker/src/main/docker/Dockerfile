FROM openjdk:8u191-jdk-alpine3.9

MAINTAINER yingzhuo yingzhor@gmail.com

WORKDIR /

USER root

VOLUME /tmp

VOLUME /var/log/application

ADD application.jar         docker-application.jar

ADD docker-entrypoint.sh    docker-entrypoint.sh

RUN chmod 755 /docker-entrypoint.sh

ENTRYPOINT ["sh", "/docker-entrypoint.sh"]

ENV TZ Asia/Shanghai

EXPOSE 8080
