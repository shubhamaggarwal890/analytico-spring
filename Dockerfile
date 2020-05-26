FROM openjdk:8
VOLUME /tmp
EXPOSE 8085
ADD /target/analytico-spring.jar analytico-spring.jar
ENTRYPOINT ["java", "-jar", "analytico-spring.jar"]
