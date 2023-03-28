FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

ADD target/weather-demo-application-0.0.1-SNAPSHOT.jar .
ADD src/main/resources/application.properties .

CMD ["java", \
"-Duser.timezone=GMT+3:00", \
"-jar", "weather-demo-application-0.0.1-SNAPSHOT.jar"]