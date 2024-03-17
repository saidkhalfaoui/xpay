# Use official PostgreSQL image from Docker Hub
FROM postgres:latest

# Expose PostgreSQL port
EXPOSE 5432

# Copy custom initialization script
COPY init-db.sh /docker-entrypoint-initdb.d/

# Grant execute permissions to the script
RUN chmod +x /docker-entrypoint-initdb.d/init-db.sh