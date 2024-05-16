FROM openjdk:17
WORKDIR /app
COPY ./build/libs/movies-0.0.1-SNAPSHOT-plain.jar /app/movies.jar
EXPOSE 8020
ENTRYPOINT ["java", "-jar", "movies.jar"]