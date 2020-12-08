FROM openjdk:8
ADD build/libs/employeeInformation-0.0.1-SNAPSHOT.jar employeeInformation-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","employeeInformation-0.0.1-SNAPSHOT.jar"]