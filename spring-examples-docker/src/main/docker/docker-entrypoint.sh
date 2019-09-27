#!/bin/sh

set -e

exec "$JAVA_HOME/bin/java" \
    -Djava.security.egd=file:/dev/./urandom \
    -Duser.timezone=${TZ:-Asia/Shanghai} \
    -Djava.io.tmpdir=/application/tmp \
    -cp  /application/lib/* \
    -jar /application/app.jar \
    --spring.profiles.active=${SPRING_PROFILES_ACTIVE:-docker} \
    ${JAVA_OPTS} \
    ${APP_OPTS}
