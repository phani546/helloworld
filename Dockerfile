FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} helloworld.jar
ENTRYPOINT ["java","-jar","/helloworld.jar"]