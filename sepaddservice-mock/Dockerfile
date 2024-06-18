FROM wiremock/wiremock:3.6.0-2-alpine

COPY mappings /home/wiremock/mappings
COPY __files /home/wiremock/__files

EXPOSE 8080

ENTRYPOINT ["/docker-entrypoint.sh", "--global-response-templating", "--disable-gzip","--disable-http2-plain", "--verbose"]