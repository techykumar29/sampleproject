FROM openjdk:17
EXPOSE 9090
ADD target/spring-test.jar spring-test.jar
ENTRYPOINT [ "java","-jar","/spring-test.jar" ]