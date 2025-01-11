#FROM openjdk:8
#EXPOSE 9999
#ADD target/eureka.jar eureka.jar
#ENTRYPOINT "java","-jar","/eureka.jar"
FROM openjdk:18
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]


  
