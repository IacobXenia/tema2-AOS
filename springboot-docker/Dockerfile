FROM openjdk:8
EXPOSE 8080
ADD /target/springboot-docker.jar  springboot-docker.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","springboot-docker.jar"]