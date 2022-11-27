# we will use openjdk 8 with alpine as it is a very small linux distro
FROM openjdk:17-jdk

# copy the packaged jar file into our docker image
COPY build/libs/messageinabottle-0.0.1-SNAPSHOT.jar /messageinabottle.jar

# set the startup command to execute the jar
CMD ["java", "-jar", "/messageinabottle.jar"]