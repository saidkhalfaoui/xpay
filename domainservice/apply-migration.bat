rem @echo off
setlocal enabledelayedexpansion

REM Load environment variables from .env.local
set "ENV_FILE=.env.local"
for /f "tokens=1,* delims==" %%a in ('type "%ENV_FILE%"') do (
    set "%%a=%%b"
    echo %%a=%%b
)

set "DB_URL=jdbc:postgresql://%DB_HOST%:%DB_PORT%/%DB_NAME%"
set "FILE_PATH=src\main\resources\db\changelog\db-changelog.yml"

mvn liquibase:update -Dliquibase.propertyFile=!FILE_PATH! -Dliquibase.url="%DB_URL%" -Dliquibase.username="%DB_USERNAME%" -Dliquibase.password="%DB_PASSWORD%" -N

cmd
