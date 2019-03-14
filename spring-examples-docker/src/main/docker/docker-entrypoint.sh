#!/bin/sh

set -o pipefail
set -e

java \
    -Djava.security.egd=file:/dev/./urandom \
    -Duser.timezone=${TZ:-Asia/Shanghai} \
    -jar /docker-application.jar \
    --spring.profiles.active=${SPRING_PROFILES_ACTIVE:-docker} \
    "$@"

exit 0
