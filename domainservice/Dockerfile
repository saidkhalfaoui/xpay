#docker pull postgres:latest
#docker run --name postgres -e POSTGRES_PASSWORD=pgadmin -e POSTGRES_DB=mainhp -p 5431:5432 -d postgres
FROM postgres:latest

ENV POSTGRES_DB mainhp
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD pgadmin

EXPOSE 5431:5432