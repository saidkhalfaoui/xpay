FROM postgres:latest

ENV POSTGRES_DB mainhp
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD pgadmin

COPY ./init.sql /docker-entrypoint-initdb.d/

EXPOSE 5431