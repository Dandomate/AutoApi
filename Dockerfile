FROM openjdk:17
COPY "./target/autoapi-0.0.2-SNAPSHOT.jar" "/app/autoapi-0.0.2-SNAPSHOT.jar"
EXPOSE 8015
CMD [ "java", "-jar", "/app/autoapi-0.0.2-SNAPSHOT.jar" ]