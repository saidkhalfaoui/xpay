#!/bin/bash

set -e

# Define database name and username
DB_NAME=mainhp
DB_USER=postgres
DB_PASS=pgadmin

# Check if the database exists
if psql -U "$POSTGRES_USER" -d "$DB_NAME" -c '\q' 2>/dev/null; then
    echo "Database $DB_NAME already exists."
else
    echo "Creating database $DB_NAME..."
    psql -U "$POSTGRES_USER" -c "CREATE DATABASE $DB_NAME;"
fi

# Create a user with password if not exists
psql -U "$POSTGRES_USER" -c "CREATE USER $DB_USER WITH PASSWORD '$DB_PASS' CREATEDB;"

# Grant all privileges on database to the user
psql -U "$POSTGRES_USER" -c "GRANT ALL PRIVILEGES ON DATABASE $DB_NAME TO $DB_USER;"
