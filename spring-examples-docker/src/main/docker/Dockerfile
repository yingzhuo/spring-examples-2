FROM openjdk:8u191-jdk-alpine3.8

MAINTAINER yingzhuo yingzhor@gmail.com

WORKDIR /

USER root

VOLUME /tmp

ADD application.jar         docker-application.jar

ADD docker-entrypoint.sh    docker-entrypoint.sh

RUN chmod 755 /docker-entrypoint.sh

ENTRYPOINT ["/docker-entrypoint.sh"]

EXPOSE 8080
