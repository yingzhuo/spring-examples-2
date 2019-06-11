#!/bin/sh

set -o pipefail
set -e

if [[ "$#" != 0 ]]; then
    $@
    exit 0
fi

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
