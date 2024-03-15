#!/bin/bash

set -o allexport; source .env.local; set +o allexport

DB_URL=jdbc:postgresql://$DB_HOST:$DB_PORT/$DB_NAME
FILE_PATH="src/main/resources/db/changelog/db-changelog.yml"


mvn liquibase:update -Dliquibase.propertyFile=$FILE_PATH -Dliquibase.url="$DB_URL" -Dliquibase.username="$DB_USERNAME" -Dliquibase.password="$DB_PASSWORD" -N

$SHELL
