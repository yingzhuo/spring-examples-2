#!/bin/sh

set -o pipefail
set -e

# startup app
exec /usr/bin/java \
    -Djava.security.egd=file:/dev/./urandom \
    -Duser.timezone=${TZ:-Asia/Shanghai} \
    -Djava.io.tmpdir=/application/tmp \
    -cp  /application/lib/* \
    -jar /application/app.jar \
    --spring.profiles.active=${SPRING_PROFILES_ACTIVE:-docker} \
    ${JAVA_OPTS} \
    ${APP_OPTS}

exit 0
