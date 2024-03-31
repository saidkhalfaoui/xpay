FROM wiremock/wiremock:latest

COPY config/ /home/wiremock/

EXPOSE 8080

ENTRYPOINT ["/docker-entrypoint.sh", "--global-response-templating", "--disable-gzip", "--verbose"]