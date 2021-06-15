FROM openjdk:11
COPY build/libs/poc-micronaut-*-all.jar poc-micronaut.jar
EXPOSE 80
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-jar", "helloworld.jar"]