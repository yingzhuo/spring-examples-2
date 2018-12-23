FROM openjdk:8-alpine
MAINTAINER yingzhuo "yingzhor@gmail.com"
VOLUME /tmp
ADD spring-boot.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
CMD ["--spring.profiles.active=docker"]
