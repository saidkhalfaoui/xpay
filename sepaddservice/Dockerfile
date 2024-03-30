# Start with a base image containing Java runtime
FROM adoptopenjdk

# Make port 8080 available to the world outside this container
EXPOSE 8081
EXPOSE 8080
ADD target/sepaddservice-0.0.1-SNAPSHOT.jar /app/app.jar
#HEALTHCHECK --interval=30s --timeout=3s \
#CMD curl  -f http://localhost:8080/api/health || exit 1
# Run the jar file
CMD ["java" , "-jar" ,"/app/app.jar"]