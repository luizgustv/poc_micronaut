FROM openjdk:11
COPY build/libs/poc-micronaut-*-all.jar poc-micronaut.jar
EXPOSE 80
CMD ["java","-jar", "poc-micronaut.jar"]

#CMD ["executable", "param1", "param2"…]
#docker build -t poc-micronaut:1.0 .