# Use official PostgreSQL image from Docker Hub as base image
FROM postgres:14.5

# Expose PostgreSQL port
EXPOSE 5432

# Copy custom initialization script for PostgreSQL
COPY init-db.sh /docker-entrypoint-initdb.d/

# Grant execute permissions to the script
RUN chmod +x /docker-entrypoint-initdb.d/init-db.sh

# Install Liquibase (choose one approach)
RUN apt-get update && apt-get install -y \
    openjdk-11-jre-headless \
    && rm -rf /var/lib/apt/lists/*

# Copy Liquibase change log files
COPY src/main/resources/db/changelog/db-changelog.yml /liquibase/changeLog/

# Run Liquibase update command
CMD ["liquibase", "update", "--changelog", "/liquibase/changeLog/db-changelog.yml", "--url", "jdbc:postgresql://localhost:5432/mainhp", "--username", "postgres", "--password", "pgadmin"]

# Volumes (optional) to persist change log files
VOLUME /liquibase/changeLog
