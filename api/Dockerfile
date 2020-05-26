FROM openjdk:8-jdk-alpine

RUN mkdir /work
COPY . /work
WORKDIR /work
RUN /work/gradlew --no-daemon build
RUN mv /work/build/libs/*.jar /work/app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/work/app.jar"]
