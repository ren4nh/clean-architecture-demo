FROM openjdk

COPY /build/layers/libs /home/app/libs
COPY /build/layers/resources /home/app/resources
COPY /build/layers/application.jar /home/app/application.jar

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/home/app/application.jar"]
